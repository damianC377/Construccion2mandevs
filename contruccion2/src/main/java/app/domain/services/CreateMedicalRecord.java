package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.MedicalRecordPort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicalRecord {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private MedicalRecordPort medicalRecordPort;
    @Autowired
    private UserPort userPort;
    @Autowired
    private UserRequireRole userRequireRole;

    // Crear historia clínica
    public void create(MedicalRecord medicalRecord) throws Exception {
        // Validar si el paciente existe
        Patient patient = patientPort.findByDocument(medicalRecord.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que el registro lo haga un doctor
        User doctor = userPort.findByDocument(medicalRecord.getDoctor());
        userRequireRole.requireRole(Role.DOCTOR);

        // Validar que el paciente no tenga ya historia clínica
        if (medicalRecordPort.findByPatient(patient) != null) {
            throw new Exception("El paciente ya tiene una historia clínica registrada");
        }

        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        medicalRecordPort.save(medicalRecord);
    }


    
}
