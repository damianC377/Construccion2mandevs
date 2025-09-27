package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;

import java.sql.Date;
import java.util.List;

public class MedicalRecordBuilder {

    private PatientValidator patientValidator;
    private UserValidator userValidator;
    private MedicalRecordValidator medicalRecordValidator;

    public MedicalRecord build(String patientDocument, String doctorDocument, String orderDate,
                               String consultationReason, String symptoms, String diagnosis,
                               List<MedicalOrder> orders) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        User doctor = new User();
        MedicalRecord medicalRecord = new MedicalRecord();
        patient.setDocument(patientValidator.documentValidator(patientDocument));
        doctor.setDocument(userValidator.documentValidator(doctorDocument));
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        // Validar y asignar los atributos del MedicalRecord
        medicalRecord.setOrderDate(medicalRecordValidator.orderDateValidator(orderDate));
        medicalRecord.setConsultationReason(medicalRecordValidator.consultationReasonValidator(consultationReason));
        medicalRecord.setSymptoms(medicalRecordValidator.symptomsValidator(symptoms));
        medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));
        medicalRecord.setOrders(orders);

        return medicalRecord;
    }
}
