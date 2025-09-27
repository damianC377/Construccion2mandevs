package app.adapter.in.builder;

import app.adapter.in.validators.MedicalRecordValidator;
import app.domain.model.*;

import java.sql.Date;
import java.util.List;

public class MedicalRecordBuilder {

    private MedicalRecordValidator medicalRecordValidator;

    public MedicalRecord build(String orderDate, String consultationReason,
                               String symptoms, String diagnosis) throws Exception {

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setOrderDate(medicalRecordValidator.orderDateValidator(orderDate));
        medicalRecord.setConsultationReason(medicalRecordValidator.consultationReasonValidator(consultationReason));
        medicalRecord.setSymptoms(medicalRecordValidator.symptomsValidator(symptoms));
        medicalRecord.setDiagnosis(medicalRecordValidator.diagnosisValidator(diagnosis));

        return medicalRecord;
    }
}
