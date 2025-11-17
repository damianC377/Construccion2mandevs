package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.MedicalRecordPort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CreateMedicalRecord {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private MedicalRecordPort medicalRecordPort;
    @Autowired
    private UserPort userPort;

    // Crear historia clínica
    public void create(MedicalRecord medicalRecord) throws Exception {
        // Validar si el paciente existe
        Patient patient = patientPort.findByDocument(medicalRecord.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que el registro lo haga un doctor
        User doctor = userPort.findByDocument(medicalRecord.getDoctor());
        requireRole(Role.DOCTOR);

        // Validar que el paciente no tenga ya historia clínica
        if (medicalRecordPort.findByPatient(patient) != null) {
            throw new BusinessException("El paciente ya tiene una historia clínica registrada");
        }

        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        medicalRecordPort.save(medicalRecord);
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
