package app.adapter.out.persistence;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.port.AuthenticationPort;
import app.infrastructure.security.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationAdapter implements AuthenticationPort {

    private final JwtUtils jwtUtils;

    public AuthenticationAdapter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role) {
        // Delegar a JwtUtils para generar token; aquí se podría validar credenciales contra DB
        String token = jwtUtils.generateToken(credentials.getUsername(), role);
        TokenResponse resp = new TokenResponse();
        resp.setToken(token);
        return resp;
    }

    @Override
    public boolean validateToken(String token) {
        return jwtUtils.validateToken(token);
    }

    @Override
    public String extractUsername(String token) {
        return jwtUtils.getUsernameFromToken(token);
    }

    @Override
    public String extractRole(String token) {
        return jwtUtils.getRoleFromToken(token);
    }
}
