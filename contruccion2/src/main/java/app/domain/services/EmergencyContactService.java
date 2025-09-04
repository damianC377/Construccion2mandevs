package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.EmergencyContactPort;
import app.domain.port.PatientPort;

public class EmergencyContactService {
    private PatientPort patientPort;
    private EmergencyContactPort emergencyContactPort;

    // Crear contacto de emergencia
    public void createEmergencyContact(EmergencyContact contact, Patient patient, User user) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        if (user == null || !user.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("El contacto de emergencia solo puede ser registrado por personal administrativo");
        }

        if (patient.getEmergencyContact() != null) {
            throw new Exception("Este paciente ya tiene un contacto de emergencia registrado");
        }

        emergencyContactPort.save(contact);
    }

    // Actualizar contacto de emergencia
    public void updateEmergencyContact(EmergencyContact contact, Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }

        emergencyContactPort.update(contact);
    }

    // Consultar contacto de emergencia
    public EmergencyContact getEmergencyContact(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }

        return patient.getEmergencyContact();
    }
}
