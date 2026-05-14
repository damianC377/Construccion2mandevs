package app.infrastructure.persistence.mapper;

import app.domain.model.EmergencyContact;
import app.infrastructure.persistence.entities.EmergencyContactEntity;

public class EmergencyContactMapper {

    // Dominio → Entidad
    public static EmergencyContactEntity toEntity(EmergencyContact domain) {
        if (domain == null) return null;

        EmergencyContactEntity entity = new EmergencyContactEntity();
        entity.setName(domain.getName());
        entity.setRelationship(domain.getRelationship());
        entity.setPhoneNumber(domain.getPhoneNumber());
        return entity;
    }

    // Entidad → Dominio
    public static EmergencyContact toDomain(EmergencyContactEntity entity) {
        if (entity == null) return null;

        EmergencyContact domain = new EmergencyContact();
        domain.setName(entity.getName());
        domain.setRelationship(entity.getRelationship());
        domain.setPhoneNumber(entity.getPhoneNumber());
        return domain;
    }
}
