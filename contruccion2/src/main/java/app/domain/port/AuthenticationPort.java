package app.domain.port;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;


public interface AuthenticationPort {

    // Generar token con credenciales y rol
    TokenResponse authenticate(AuthCredentials credentials, String role);

    // Verificar si el token es válido
    boolean validateToken(String token);

    // Obtener el nombre de usuario desde el token
    String extractUsername(String token);

    // Obtener el rol desde el token
    String extractRole(String token);
}
