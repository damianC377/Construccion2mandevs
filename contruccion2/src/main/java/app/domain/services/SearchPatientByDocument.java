package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchPatientByDocument {
    @Autowired
	private PatientPort patientPort;
    @Autowired
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
