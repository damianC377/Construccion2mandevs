package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.EmergencyContactPort;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEmergencyContact {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private EmergencyContactPort emergencyContactPort;
    @Autowired
    private UserRequireRole userRequireRole;

    // Crear contacto de emergencia
    public void create(EmergencyContact contact, Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        // Validar que el paciente no tenga contacto registrado
        if (patient.getEmergencyContact() != null) {
            throw new Exception("Este paciente ya tiene un contacto de emergencia registrado");
        }

        // Asociar contacto al paciente
        patient.setEmergencyContact(contact);

        emergencyContactPort.save(contact);
    }

}
