package app.domain.services;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.MedicalRecordPort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;

public class MedicalRecordService {

    private PatientPort patientPort;
    private MedicalRecordPort medicalRecordPort;
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
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("La historia clínica solo puede ser registrada por un doctor");
        }

        // Validar que el paciente no tenga ya historia clínica
        if (medicalRecordPort.findByPatient(patient) != null) {
            throw new Exception("El paciente ya tiene una historia clínica registrada");
        }

        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        medicalRecordPort.save(medicalRecord);
    }


    // Consultar historia clínica
    public MedicalRecord getByPatient(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        MedicalRecord record = medicalRecordPort.findByPatient(patient);
        if (record == null) {
            throw new Exception("El paciente no tiene historia clínica registrada");
        }

        return record;
    }
}
