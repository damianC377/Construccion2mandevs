package app.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import app.domain.port.AuthenticationPort;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Permite usar anotaciones @PreAuthorize/@PostAuthorize
public class SecurityConfig {

    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationPort authenticationPort) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Endpoints de login abiertos
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Solo ADMIN puede acceder

                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
            .addFilterBefore(jwtAuthenticationFilter(authenticationPort), UsernamePasswordAuthenticationFilter.class); // Añadir filtro JWT antes del filtro por defecto

        return http.build(); // Construye la cadena de filtros
    }

    @Bean
    // Filtro que valida tokens JWT en cada petición
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationPort authenticationPort) {
        return new JwtAuthenticationFilter(authenticationPort);
    }

    @Bean
    // Encripta y valida contraseñas usando BCrypt
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
