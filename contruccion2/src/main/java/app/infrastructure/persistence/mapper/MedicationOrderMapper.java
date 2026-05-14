package app.infrastructure.persistence.mapper;

import app.domain.model.MedicationOrder;
import app.domain.model.MedicationInventory;
import app.infrastructure.persistence.entities.MedicationOrderEntity;
import app.infrastructure.persistence.entities.MedicationInventoryEntity;

public class MedicationOrderMapper {

    /**
     * Convierte un objeto de dominio (MedicationOrder) en una entidad JPA (MedicationOrderEntity)
     */
    public static MedicationOrderEntity toEntity(MedicationOrder order) {
        if (order == null) return null;

        MedicationOrderEntity entity = new MedicationOrderEntity();

        // Campos heredados de Order
        entity.setOrderNumber(order.getOrderNumber());
        entity.setItmNumber(order.getItemNumber());
        entity.setCost(order.getCost());

        // Campos propios de MedicationOrder
        MedicationInventoryEntity medEntity = new MedicationInventoryEntity();
        if (order.getMedication() != null) {
            medEntity.setId(order.getMedication().getId());
            medEntity.setName(order.getMedication().getName());
            medEntity.setCost(order.getMedication().getCost());
        }
        entity.setMedication(medEntity);

        entity.setDosage(order.getDosage());
        entity.setTreatmentDuration(order.getTreatmentDuration());

        return entity;
    }

    /**
     * Convierte una entidad JPA (MedicationOrderEntity) en un objeto de dominio (MedicationOrder)
     */
    public static MedicationOrder toDomain(MedicationOrderEntity entity) {
        if (entity == null) return null;

        MedicationOrder order = new MedicationOrder();

        // Campos heredados de Order
        order.setOrderNumber(entity.getOrderNumber());
        order.setItemNumber(entity.getItmNumber());
        order.setCost(entity.getCost());

        // Campos propios de MedicationOrder
        if (entity.getMedication() != null) {
            MedicationInventory medication = new MedicationInventory();
            medication.setId(entity.getMedication().getId());
            medication.setName(entity.getMedication().getName());
            medication.setCost(entity.getMedication().getCost());
            order.setMedication(medication);
        }

        order.setDosage(entity.getDosage());
        order.setTreatmentDuration(entity.getTreatmentDuration());

        return order;
    }
}
