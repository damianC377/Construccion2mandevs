package app.infrastructure.persistence.mapper;

import app.domain.model.Invoice;
import app.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    // Dominio → Entidad
    public static InvoiceEntity toEntity(Invoice domain) {
        if (domain == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setId(domain.getId());

        // Mapeo de relaciones (se delega a los mappers de Patient, User, HealthInsurance y MedicalOrder)
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setInsurance(HealthInsuranceMapper.toEntity(domain.getInsurance()));
        entity.setMedicalOrder(MedicalOrderMapper.toEntity(domain.getMedicalOrder()));

        entity.setPolicyNumber(domain.getPolicyNumber());
        entity.setPolicyValidityDays(domain.getPolicyValidityDays());
        entity.setPolicyEndDate(domain.getPolicyEndDate());

        return entity;
    }

    // Entidad → Dominio
    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice domain = new Invoice();
        domain.setId(entity.getId());

        // Mapeo de relaciones (se delega a los mappers de Patient, User, HealthInsurance y MedicalOrder)
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setInsurance(HealthInsuranceMapper.toDomain(entity.getInsurance()));
        domain.setMedicalOrder(MedicalOrderMapper.toDomain(entity.getMedicalOrder()));

        domain.setPolicyNumber(entity.getPolicyNumber());
        domain.setPolicyValidityDays(entity.getPolicyValidityDays());
        domain.setPolicyEndDate(entity.getPolicyEndDate());

        return domain;
    }
}
