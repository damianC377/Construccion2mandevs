package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;

public class SearchHealthInsuranceByPatient {
	
	private PatientPort patientPort;
	private UserRequireRole userRequireRole;
	
	   // Consultar seguro de salud por paciente
    public HealthInsurance search(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene seguro
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }
        
     // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        return patient.getHealthInsurance();
    }
    
}
