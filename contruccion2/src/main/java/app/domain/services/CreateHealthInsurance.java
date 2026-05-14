package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class CreateHealthInsurance {

    @Autowired
    private HealthInsurancePort healthInsurancePort;

    // Crear seguro de salud
    public void create(HealthInsurance healthInsurance) throws Exception {

        // Validar que lo registre personal administrativo
        requireRole(Role.ADMINISTRATIVE_STAFF);

        healthInsurancePort.save(healthInsurance);
    }

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }

}
