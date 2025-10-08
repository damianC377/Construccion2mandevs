package app.infrastructure.persistence.mapper;

import app.domain.model.ProcedureInventory;
import app.infrastructure.persistence.entities.ProcedureInventoryEntity;

public class ProcedureInventoryMapper {

    // Dominio → Entidad
    public static ProcedureInventoryEntity toEntity(ProcedureInventory domain) {
        if (domain == null) return null;

        ProcedureInventoryEntity entity = new ProcedureInventoryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setCost(domain.getCost());
        return entity;
    }

    // Entidad → Dominio
    public static ProcedureInventory toDomain(ProcedureInventoryEntity entity) {
        if (entity == null) return null;

        ProcedureInventory domain = new ProcedureInventory();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setCost(entity.getCost());
        return domain;
    }
}
