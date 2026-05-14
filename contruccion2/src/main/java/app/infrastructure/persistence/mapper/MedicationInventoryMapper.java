package app.infrastructure.persistence.mapper;

import app.domain.model.MedicationInventory;
import app.infrastructure.persistence.entities.MedicationInventoryEntity;

public class MedicationInventoryMapper {

    // Dominio → Entidad
    public static MedicationInventoryEntity toEntity(MedicationInventory domain) {
        if (domain == null) return null;

        MedicationInventoryEntity entity = new MedicationInventoryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setCost(domain.getCost());
        return entity;
    }

    // Entidad → Dominio
    public static MedicationInventory toDomain(MedicationInventoryEntity entity) {
        if (entity == null) return null;

        MedicationInventory domain = new MedicationInventory();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setCost(entity.getCost());
        return domain;
    }
}
