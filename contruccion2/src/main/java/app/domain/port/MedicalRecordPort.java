package app.domain.port;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public interface MedicalRecordPort {

    // Crear historia clínica
    public void save(MedicalRecord medicalRecord) throws Exception;

    // Actualizar historia clínica
    public void update(MedicalRecord medicalRecord) throws Exception;

    // Consultar historia clínica por paciente
    public MedicalRecord findByPatient(Patient patient) throws Exception;
}
