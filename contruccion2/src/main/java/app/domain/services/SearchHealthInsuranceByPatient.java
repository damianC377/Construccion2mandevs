package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchHealthInsuranceByPatient {
    @Autowired
	private PatientPort patientPort;
    @Autowired
	private UserRequireRole userRequireRole;
	
	   // Consultar seguro de salud por paciente
    public HealthInsurance search(Patient patient) throws Exception {
    	//Buscar el paciente
    	if (patient == null) {
            throw new Exception("El paciente no existe");
        }
    	
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
