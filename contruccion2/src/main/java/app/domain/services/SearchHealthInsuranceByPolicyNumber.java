package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;

public class SearchHealthInsuranceByPolicyNumber {
	
	private HealthInsurancePort healthInsurancePort;
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
