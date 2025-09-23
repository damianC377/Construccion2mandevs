package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.domain.model.*;

import java.sql.Date;
import java.util.List;

public class MedicalRecordBuilder {

    private final MedicalRecordValidator medicalRecordValidator;

    public MedicalRecordBuilder(MedicalRecordValidator medicalRecordValidator) {
        this.medicalRecordValidator = medicalRecordValidator;
    }

    public MedicalRecord build(Patient patient, String orderDate, User doctor, String consultationReason,
                               String symptoms, String diagnosis, List<MedicalOrder> orders) throws Exception {

        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setPatient(medicalRecordValidator.patientValidator(patient));
        medicalRecord.setOrderDate(medicalRecordValidator.orderDateValidator(orderDate));
        medicalRecord.setDoctor(medicalRecordValidator.doctorValidator(doctor));
        medicalRecord.setConsultationReason(medicalRecordValidator.consultationReasonValidator(consultationReason));
        medicalRecord.setSymptoms(medicalRecordValidator.symptomsValidator(symptoms));
        medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));
        medicalRecord.setOrders(medicalRecordValidator.ordersValidator(orders));

        return medicalRecord;
    }
}
