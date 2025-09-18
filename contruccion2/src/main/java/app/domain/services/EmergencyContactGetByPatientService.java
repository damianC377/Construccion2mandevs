package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.port.PatientPort;

public class EmergencyContactGetByPatientService {
	private PatientPort patientPort;
	
	// Consultar contacto de emergencia por paciente
    public EmergencyContact getByPatient(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene contacto
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }

        // Devolver contacto
        return patient.getEmergencyContact();
    }
}
