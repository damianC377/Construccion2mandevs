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
    public void create(EmergencyContact contact, Patient patient, User administrativeStaff) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que lo registre personal administrativo
        if (administrativeStaff == null || !administrativeStaff.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("El contacto de emergencia solo puede ser registrado por personal administrativo");
        }

        // Validar que el paciente no tenga contacto registrado
        if (patient.getEmergencyContact() != null) {
            throw new Exception("Este paciente ya tiene un contacto de emergencia registrado");
        }

        // Asociar contacto al paciente
        patient.setEmergencyContact(contact);

        // Guardar contacto
        emergencyContactPort.save(contact);
    }

    // Actualizar contacto de emergencia
    public void update(EmergencyContact contact, Patient patient) throws Exception {
        // Validar si el paciente existe y tiene contacto
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }

        // Actualizar contacto
        emergencyContactPort.update(contact);
    }

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
