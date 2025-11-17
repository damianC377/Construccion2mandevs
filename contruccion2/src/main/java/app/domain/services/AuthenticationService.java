package app.domain.services;

import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.port.AuthenticationPort;
import app.domain.port.UserPort;
import app.application.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.domain.model.enums.Role;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationPort authenticationPort;

    @Autowired
    private UserPort userPort;
    
    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    // Metodo principal para autenticar y validar usuario
    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        User user = this.getUserByUsername(credentials.getUsername());
        this.validatePassword(credentials.getPassword(), user.getPassword());
        // Pasar el nombre del role (ej. "HUMAN_RESOURCES") para que JwtUtils lo incluya en el token
        String roleName = user.getRole() != null ? user.getRole().name() : null;
        return authenticationPort.authenticate(credentials, roleName); // Generar token
    }

    // Verifica que el usuario autenticado tenga un role específico
    public void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }

    // Verifica que el usuario autenticado tenga al menos uno de los roles indicados
    public void requireAnyRole(Role... roles) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        for (Role r : roles) {
            String needed = "ROLE_" + r.name();
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed))) {
                return;
            }
        }
        throw new BusinessException("Acceso denegado");
    }

    // Obtener usuario desde la base de datos por el Username
    private User getUserByUsername(String username) throws Exception {
        User user = new User();
        user.setUserName(username);
        user = userPort.findByUserName(user);
        if (user == null) {
            throw new BusinessException("Usuario no encontrado");
        }
        return user;
    }

    // Validar que la contraseña ingresada coincida
    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (storedPassword == null) {
            throw new BusinessException("Contraseña incorrecta");
        }

        // Si hay un PasswordEncoder disponible y la contraseña almacenada parece estar hasheada (BCrypt), usar matches
        if (passwordEncoder != null && (storedPassword.startsWith("$2a$") || storedPassword.startsWith("$2b$") || storedPassword.startsWith("$2y$"))) {
            if (!passwordEncoder.matches(inputPassword, storedPassword)) {
                throw new BusinessException("Contraseña incorrecta");
            }
        } else {
            // Comparación simple (legacy/plain)
            if (!inputPassword.equals(storedPassword)) {
                throw new BusinessException("Contraseña incorrecta");
            }
        }
    }
}
