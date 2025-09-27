package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import app.domain.port.PatientPort;

public class SearchHealthInsuranceByPatient {
	
	private PatientPort patientPort;
	private HealthInsurancePort healthInsurancePort;
	private UserRequireRole userRequireRole;
	
	   // Consultar seguro de salud por paciente
    public HealthInsurance search(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene seguro
        patient = patientPort.findByDocument(patient);
        
        // Validar si el paciente existe
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }
        
     // Validar que el paciente no tenga seguro registrado
        if (patient.getHealthinsurance() == 0) {
            throw new Exception("Este paciente no tiene un seguro registrado");
        }
        
        HealthInsurance insurance = healthInsurancePort.findById(patient.getHealthinsurance());
        if(insurance == null) {
        	throw new Exception("El seguro asociado no existe en el sistema");
        }
        
     // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        return insurance;
    }
    
}
