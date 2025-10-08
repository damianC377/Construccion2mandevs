package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MedicalRecordBuilder {

    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private MedicalRecordValidator medicalRecordValidator;

    public MedicalRecord build(String patientDocument, String doctorDocument, String orderDate,
                               String consultationReason, String symptoms, String diagnosis,
                               List<MedicalOrder> orders) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        User doctor = new User();
        MedicalRecord medicalRecord = new MedicalRecord();

        // Validar y asignar los atributos del MedicalRecord
        patient.setDocument(patientValidator.documentValidator(patientDocument));
        doctor.setDocument(userValidator.documentValidator(doctorDocument));
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setOrderDate(medicalRecordValidator.orderDateValidator(orderDate));
        medicalRecord.setConsultationReason(medicalRecordValidator.consultationReasonValidator(consultationReason));
        medicalRecord.setSymptoms(medicalRecordValidator.symptomsValidator(symptoms));
        medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));
        medicalRecord.setOrders(orders);

        return medicalRecord;
    }
}
