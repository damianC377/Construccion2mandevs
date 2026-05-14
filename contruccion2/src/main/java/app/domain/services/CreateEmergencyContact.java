package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.EmergencyContactPort;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CreateEmergencyContact {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private EmergencyContactPort emergencyContactPort;

    // Crear contacto de emergencia
    public void create(EmergencyContact contact, Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que lo registre personal administrativo
        requireRole(Role.ADMINISTRATIVE_STAFF);

        // Validar que el paciente no tenga contacto registrado
        if (patient.getEmergencyContact() != null) {
            throw new BusinessException("Este paciente ya tiene un contacto de emergencia registrado");
        }

        // Asociar contacto al paciente
        patient.setEmergencyContact(contact);

        emergencyContactPort.save(contact);
    }

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }

}
