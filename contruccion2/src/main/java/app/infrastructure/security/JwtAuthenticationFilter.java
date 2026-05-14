package app.infrastructure.security;

import app.domain.port.AuthenticationPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;

// Filtro que se ejecuta una vez por cada petición para verificar JWT
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationPort authenticationPort; // Puerto para validar token

    public JwtAuthenticationFilter(AuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    // Metodo principal del filtro
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = this.extractToken(request); // Obtener token del header/encabezado de la petición

        if (token != null) {
            this.processToken(token); // Procesar y validar token
        }

        filterChain.doFilter(request, response); // Continuar con la petición
    }

    // Extrae el token del header "Authorization"
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // Quitar "Bearer " y retornar token
        }
        return null;
    }

    // Procesa el token y lo convierte en autenticación de Spring
    private void processToken(String token) {
        if (authenticationPort.validateToken(token)) { // Validar que el token sea correcto
            String username = authenticationPort.extractUsername(token);
            String role = authenticationPort.extractRole(token);

            if (role == null || role.trim().isEmpty()) {
                return; // Si no hay rol, no autentica
            }

            // Normalizar rol para Spring Security
            String normalized = role.trim();
            if (!normalized.toUpperCase().startsWith("ROLE_")) {
                normalized = "ROLE_" + normalized.toUpperCase();
            } else {
                normalized = normalized.toUpperCase();
            }

            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(normalized)); // Agregar autoridad

            // Crear objeto de autenticación
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    authorities
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
}
