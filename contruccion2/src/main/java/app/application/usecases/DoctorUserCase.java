package app.application.usecases;

import app.domain.model.MedicalOrder;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.services.*;

import java.util.List;

public class DoctorUserCase {

    private CreateMedicalRecordService createMedicalRecordService;
    private SearchMedicalRecordByPatientService searchMedicalRecordByPatientService;

    private CreateMedicalOrderService createMedicalOrderService;
    private SearchMedicalOrderByPatientService searchMedicalOrderByPatientService;

    private SearchPatientByDocumentService searchPatientByDocumentService;

    // Crear y buscar historia clínica
    public void createMedicalRecord(MedicalRecord medicalRecord) throws Exception {
        createMedicalRecordService.create(medicalRecord);
    }
    public MedicalRecord searchMedicalRecord(Patient patient) throws Exception {
        return searchMedicalRecordByPatientService.search(patient);
    }

    // Crear y buscar ordenes médicas
    public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
        createMedicalOrderService.createMedicalOrder(medicalOrder);
    }
    public List<MedicalOrder> searchMedicalOrder(Patient patient) throws Exception {
        return searchMedicalOrderByPatientService.search(patient);
    }

    // Buscar paciente
    public Patient searchPatientByDocument(Patient patient) throws Exception{
        return searchPatientByDocumentService.search(patient);
    }


}
