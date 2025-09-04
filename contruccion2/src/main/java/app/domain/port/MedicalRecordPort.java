package app.domain.port;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public interface MedicalRecordPort {
    // Encontrar historia clinica por id
    public MedicalRecord findById(MedicalRecord medicalRecord) throws Exception;

    // Crear historia clinica
    public void save(MedicalRecord medicalRecord) throws Exception;

    // Actualizar hidtoria cilinics
    public void update(MedicalRecord medicalRecord) throws Exception;

    // Consultar historia clinica
    public void getById(MedicalRecord medicalRecord) throws Exception;

}
