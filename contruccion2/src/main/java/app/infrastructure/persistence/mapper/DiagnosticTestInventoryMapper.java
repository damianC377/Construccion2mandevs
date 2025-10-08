package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticTestInventory;
import app.infrastructure.persistence.entities.DiagnosticTestInventoryEntity;

public class DiagnosticTestInventoryMapper {

    // Dominio → Entidad
    public static DiagnosticTestInventoryEntity toEntity(DiagnosticTestInventory domain) {
        if (domain == null) return null;

        DiagnosticTestInventoryEntity entity = new DiagnosticTestInventoryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setCost(domain.getCost());
        return entity;
    }

    // Entidad → Dominio
    public static DiagnosticTestInventory toDomain(DiagnosticTestInventoryEntity entity) {
        if (entity == null) return null;

        DiagnosticTestInventory domain = new DiagnosticTestInventory();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setCost(entity.getCost());
        return domain;
    }
}
