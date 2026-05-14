package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchEmergencyContactByPatient {
    @Autowired
    private PatientPort patientPort;
    
    // Consultar contacto de emergencia por paciente
    public EmergencyContact search(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene contacto
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getEmergencyContact() == null) {
            throw new Exception("El paciente no tiene contacto de emergencia registrado");
        }
        
        // Validar que lo registre personal administrativo
        requireRole(Role.ADMINISTRATIVE_STAFF);

        // Devolver contacto
        return patient.getEmergencyContact();
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
