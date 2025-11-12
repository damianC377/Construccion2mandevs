package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.infrastructure.persistence.entities.MedicalRecordEntity;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordMapper {

    public static MedicalRecord toDomain(MedicalRecordEntity entity) {
        if (entity == null) return null;
        MedicalRecord mr = new MedicalRecord();
        Patient p = new Patient(); p.setId(entity.getPatientId());
        User u = new User(); u.setId(entity.getDoctorId());
        mr.setId(entity.getId());
        mr.setPatient(p);
        mr.setDoctor(u);
        mr.setOrderDate(entity.getOrderDate());
        mr.setConsultationReason(entity.getConsultationReason());
        mr.setSymptoms(entity.getSymptoms());
        mr.setDiagnosis(entity.getDiagnosis());
        mr.setOrders(new ArrayList<>());
        return mr;
    }

    public static MedicalRecordEntity toEntity(MedicalRecord domain) {
        if (domain == null) return null;
        MedicalRecordEntity e = new MedicalRecordEntity();
        e.setId(domain.getId());
        e.setPatientId(domain.getPatient() != null ? domain.getPatient().getId() : null);
        e.setDoctorId(domain.getDoctor() != null ? domain.getDoctor().getId() : null);
        e.setOrderDate(domain.getOrderDate());
        e.setConsultationReason(domain.getConsultationReason());
        e.setSymptoms(domain.getSymptoms());
        e.setDiagnosis(domain.getDiagnosis());
        return e;
    }
}
