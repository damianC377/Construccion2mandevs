package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;


public class CreateHealthInsurance {

    private HealthInsurancePort healthInsurancePort;
    private UserRequireRole userRequireRole;

    // Crear seguro de salud
    public void create(HealthInsurance healthInsurance) throws Exception {
    	
    	

        // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        healthInsurancePort.save(healthInsurance);
    }

}
