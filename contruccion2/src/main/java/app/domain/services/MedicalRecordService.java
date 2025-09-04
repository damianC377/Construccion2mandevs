package app.domain.services;



import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.port.MedicalRecordPort;

public class MedicalRecordService {
    private Patient patient;
    private MedicalRecordPort medicalRecordPort;


    // Crear nueva historia clínica
    public void createMedicalRecord(MedicalRecord record) throws Exception {
        if (medicalRecordPort.findById(record) != null) {
            throw new Exception("Ya existe una historia clínica con este ID");
        }
        medicalRecordPort.save(record);
    }
    // Actualizar historia clínica
    public void updateMedicalRecord(MedicalRecord record) throws Exception {
        if (medicalRecordPort.findById(record) == null) {
            throw new Exception("Historia clínica no encontrada");
        }
        medicalRecordPort.update(record);
    }
    // Consultar historia clinica



}
