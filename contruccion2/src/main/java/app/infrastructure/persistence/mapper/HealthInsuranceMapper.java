package app.infrastructure.persistence.mapper;

import app.domain.model.HealthInsurance;
import app.infrastructure.persistence.entities.HealthInsuranceEntity;

public class HealthInsuranceMapper {

    // Dominio → Entidad
    public static HealthInsuranceEntity toEntity(HealthInsurance domain) {
        if (domain == null) return null;

        HealthInsuranceEntity entity = new HealthInsuranceEntity();
        entity.setCompanyName(domain.getCompanyName());
        entity.setPolicyNumber(domain.getPolicyNumber());
        entity.setActive(domain.isActive());
        entity.setEndDate(domain.getEndDate());
        return entity;
    }

    // Entidad → Dominio
    public static HealthInsurance toDomain(HealthInsuranceEntity entity) {
        if (entity == null) return null;

        HealthInsurance domain = new HealthInsurance();
        domain.setCompanyName(entity.getCompanyName());
        domain.setPolicyNumber(entity.getPolicyNumber());
        domain.setActive(entity.isActive());
        domain.setEndDate(entity.getEndDate());
        return domain;
    }
}
