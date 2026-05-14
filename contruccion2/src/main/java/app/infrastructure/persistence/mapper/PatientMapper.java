package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    // Dominio → Entidad
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;

        PatientEntity entity = new PatientEntity();
        entity.setId(domain.getId());
        entity.setDocument(domain.getDocument());
        entity.setFullName(domain.getFullName());
        entity.setDateOfBirth(domain.getDateOfBirth());
        entity.setGender(domain.getGender());
        entity.setAddress(domain.getAddress());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmailAddress(domain.getEmailAddress());

        // Mapeo de relaciones (se delega a los mappers de EmergencyContact y HealthInsurance)
        entity.setEmergencyContact(EmergencyContactMapper.toEntity(domain.getEmergencyContact()));
        entity.setHealthInsurance(HealthInsuranceMapper.toEntity(domain.getHealthInsurance()));

        return entity;
    }

    // Entidad → Dominio
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        Patient domain = new Patient();
        domain.setId(entity.getId());
        domain.setDocument(entity.getDocument());
        domain.setFullName(entity.getFullName());
        domain.setDateOfBirth(entity.getDateOfBirth());
        domain.setGender(entity.getGender());
        domain.setAddress(entity.getAddress());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setEmailAddress(entity.getEmailAddress());

        // Mapeo de relaciones (se delega a los mappers de EmergencyContact y HealthInsurance)
        domain.setEmergencyContact(EmergencyContactMapper.toDomain(entity.getEmergencyContact()));
        domain.setHealthInsurance(HealthInsuranceMapper.toDomain(entity.getHealthInsurance()));

        return domain;
    }
}
