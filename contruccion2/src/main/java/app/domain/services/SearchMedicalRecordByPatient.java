package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.MedicalRecordPort;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchMedicalRecordByPatient {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private MedicalRecordPort medicalRecordPort;
    
    // Consultar historia clínica por paciente
    public MedicalRecord search(Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        MedicalRecord record = medicalRecordPort.findByPatient(patient);
        if (record == null) {
            throw new Exception("El paciente no tiene historia clínica registrada");
        }
        
        requireAnyRole(Role.NURSE, Role.DOCTOR);

        return record;
    }

    private void requireAnyRole(Role... roles) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        boolean ok = false;
        for (Role r : roles) {
            String needed = "ROLE_" + r.name();
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed))) {
                ok = true;
                break;
            }
        }
        if (!ok) throw new BusinessException("Acceso denegado");
    }
}
