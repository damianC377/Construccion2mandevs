package app.application;

import app.domain.services.CreateMedicalOrderService;
import app.domain.services.CreateMedicalRecordService;
import app.domain.services.SearchMedicalOrder;
import app.domain.services.SearchMedicalRecord;
import app.domain.services.SearchPatient;

import java.util.List;

import app.domain.model.MedicalOrder;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public class NurseUserCase {
    private CreateMedicalRecordService createMedicalRecordService;
    private SearchMedicalRecord searchMedicalRecordByPatientService;

    private CreateMedicalOrderService createMedicalOrderService;
    private SearchMedicalOrder searchMedicalOrderByPatientService;

    private SearchPatient searchPatientByDocumentService;

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
