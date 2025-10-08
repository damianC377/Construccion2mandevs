package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchEmergencyContactByPatient {
    @Autowired
	private PatientPort patientPort;
    @Autowired
	private UserRequireRole userRequireRole;
	
	// Consultar contacto de emergencia por paciente
    public EmergencyContact search(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene contacto
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }
        
        // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        // Devolver contacto
        return patient.getEmergencyContact();
    }
}
