package app.infrastructure.persistence.mapper;

import app.domain.model.ProcedureOrder;
import app.domain.model.ProcedureInventory;
import app.infrastructure.persistence.entities.ProcedureOrderEntity;
import app.infrastructure.persistence.entities.ProcedureInventoryEntity;

public class ProcedureOrderMapper {

    // === De dominio a entidad (para guardar en base de datos) ===
    public static ProcedureOrderEntity toEntity(ProcedureOrder order) {
        if (order == null) return null;

        ProcedureOrderEntity entity = new ProcedureOrderEntity();
        entity.setOrderNumber(order.getOrderNumber());
        entity.setItmNumber(order.getItemNumber());
        entity.setCost(order.getCost());
        entity.setQuantity(order.getQuantity());
        entity.setFrequency(order.getFrequency());
        entity.setRequiresSpecialist(order.isRequiresSpecialist());
        entity.setSpecialist(order.getSpecialist());

        // Mapea el procedimiento (inventario asociado)
        if (order.getProcedure() != null) {
            ProcedureInventoryEntity inventoryEntity = new ProcedureInventoryEntity();
            inventoryEntity.setId(order.getProcedure().getId());
            inventoryEntity.setName(order.getProcedure().getName());
            inventoryEntity.setCost(order.getProcedure().getCost());
            entity.setProcedure(inventoryEntity);
        }

        return entity;
    }

    // === De entidad a dominio (para usar en la lógica de negocio) ===
    public static ProcedureOrder toDomain(ProcedureOrderEntity entity) {
        if (entity == null) return null;

        ProcedureOrder order = new ProcedureOrder();
        order.setOrderNumber(entity.getOrderNumber());
        order.setItemNumber(entity.getItmNumber());
        order.setCost(entity.getCost());
        order.setQuantity(entity.getQuantity());
        order.setFrequency(entity.getFrequency());
        order.setRequiresSpecialist(entity.isRequiresSpecialist());
        order.setSpecialist(entity.getSpecialist());

        // Mapea el inventario asociado
        if (entity.getProcedure() != null) {
            ProcedureInventory inventory = new ProcedureInventory();
            inventory.setId(entity.getProcedure().getId());
            inventory.setName(entity.getProcedure().getName());
            inventory.setCost(entity.getProcedure().getCost());
            order.setProcedure(inventory);
        }

        return order;
    }
}
