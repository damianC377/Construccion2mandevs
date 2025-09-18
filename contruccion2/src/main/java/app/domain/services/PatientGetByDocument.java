package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;

public class PatientGetByDocument {
	
	private PatientPort patientPort;
	private UserRequireRoleService userRequireRole;
	
    // Consultar paciente
    public Patient getByDocument(Patient patient) throws Exception {
        // Buscar paciente por documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient == null) {
            throw new Exception("Paciente no encontrado");
        }
        
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        return foundPatient;
    }

}
