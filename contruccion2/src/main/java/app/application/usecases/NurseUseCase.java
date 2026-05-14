package app.application.usecases;

import app.domain.services.CreateMedicalOrder;
import app.domain.services.CreateMedicalRecord;
import app.domain.services.SearchMedicalOrderByPatient;
import app.domain.services.SearchMedicalRecordByPatient;
import app.domain.services.SearchPatientByDocument;
import java.util.List;
import app.domain.model.MedicalOrder;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseUseCase {

    @Autowired
    private CreateMedicalRecord createMedicalRecord;
    private SearchMedicalRecordByPatient searchMedicalRecordByPatient;

    @Autowired
    private CreateMedicalOrder createMedicalOrder;
    private SearchMedicalOrderByPatient searchMedicalOrderByPatient;

    private SearchPatientByDocument searchPatientByDocument;

    // Crear y buscar historia clínica
    public void createMedicalRecord(MedicalRecord medicalRecord) throws Exception {
        createMedicalRecord.create(medicalRecord);
    }
    public MedicalRecord searchMedicalRecord(Patient patient) throws Exception {
        return searchMedicalRecordByPatient.search(patient);
    }

    // Crear y buscar ordenes médicas
    public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
        createMedicalOrder.create(medicalOrder);
    }
    public List<MedicalOrder> searchMedicalOrder(Patient patient) throws Exception {
        return searchMedicalOrderByPatient.search(patient);
    }

    // Buscar paciente
    public Patient searchPatientByDocument(Patient patient) throws Exception{
        return searchPatientByDocument.search(patient);

    }
}
