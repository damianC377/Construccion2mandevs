package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchHealthInsuranceByPolicyNumber {
    @Autowired
	private HealthInsurancePort healthInsurancePort;
    @Autowired
	private UserRequireRole userRequireRole;
	
	public HealthInsurance searchByPolicy(String policyNumber) throws Exception{
		HealthInsurance insurance = healthInsurancePort.findByPolicyNumber(policyNumber);
		
		if(insurance == null) {
			throw new Exception("No existe un seguro con la poliza "+ policyNumber);
		}
		
		// Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);
		
		return insurance;
	}
}
