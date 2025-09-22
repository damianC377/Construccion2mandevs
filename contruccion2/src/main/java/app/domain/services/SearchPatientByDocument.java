package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;

public class SearchPatientByDocument {
	
	private PatientPort patientPort;
	private UserRequireRole userRequireRole;
	
    // Consultar paciente
    public Patient search(Patient patient) throws Exception {
        // Buscar paciente por documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient == null) {
            throw new Exception("Paciente no encontrado");
        }
        
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        return foundPatient;
    }

}
