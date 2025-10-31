package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticTestInventory;
import app.domain.model.DiagnosticTestOrder;
import app.infrastructure.persistence.entities.DiagnosticTestInventoryEntity;
import app.infrastructure.persistence.entities.DiagnosticTestOrderEntity;

public class DiagnosticTestOrderMapper {

    /**
     * Convierte un objeto de dominio (DiagnosticTestOrder) en una entidad JPA (DiagnosticTestOrderEntity)
     */
    public static DiagnosticTestOrderEntity toEntity(DiagnosticTestOrder order) {
        if (order == null) return null;

        DiagnosticTestOrderEntity entity = new DiagnosticTestOrderEntity();

        // Campos heredados de Order
        entity.setOrderNumber(order.getOrderNumber());
        entity.setItmNumber(order.getItemNumber());
        entity.setCost(order.getCost());

        // Campos propios de DiagnosticTestOrder
        if (order.getDiagnosticTestInventory() != null) {
            DiagnosticTestInventoryEntity invEntity = new DiagnosticTestInventoryEntity();
            invEntity.setId(order.getDiagnosticTestInventory().getId());
            invEntity.setName(order.getDiagnosticTestInventory().getName());
            invEntity.setCost(order.getDiagnosticTestInventory().getCost());
            entity.setDiagnosticTestInventory(invEntity);
        }

        entity.setQuantity(order.getQuantity());
        entity.setRequiresSpecialist(order.isRequiresSpecialist());
        entity.setSpecialist(order.getSpecialist());

        return entity;
    }

    /**
     * Convierte una entidad JPA (DiagnosticTestOrderEntity) en un objeto de dominio (DiagnosticTestOrder)
     */
    public static DiagnosticTestOrder toDomain(DiagnosticTestOrderEntity entity) {
        if (entity == null) return null;

        DiagnosticTestOrder order = new DiagnosticTestOrder();

        // Campos heredados de Order
        order.setOrderNumber(entity.getOrderNumber());
        order.setItemNumber(entity.getItmNumber());
        order.setCost(entity.getCost());

        // Campos propios de DiagnosticTestOrder
        if (entity.getDiagnosticTestInventory() != null) {
            DiagnosticTestInventory inventory = new DiagnosticTestInventory();
            inventory.setId(entity.getDiagnosticTestInventory().getId());
            inventory.setName(entity.getDiagnosticTestInventory().getName());
            inventory.setCost(entity.getDiagnosticTestInventory().getCost());
            order.setDiagnosticTestInventory(inventory);
        }

        order.setQuantity(entity.getQuantity());
        order.setRequiresSpecialist(entity.isRequiresSpecialist());
        order.setSpecialist(entity.getSpecialist());

        return order;
    }
}
