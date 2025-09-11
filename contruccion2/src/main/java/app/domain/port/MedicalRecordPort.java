package app.domain.port;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public interface MedicalRecordPort {

    // Guardar historia clínica
    public void save(MedicalRecord medicalRecord) throws Exception;

    // Consultar historia clínica por paciente
    public MedicalRecord findByPatient(Patient patient) throws Exception;
}
