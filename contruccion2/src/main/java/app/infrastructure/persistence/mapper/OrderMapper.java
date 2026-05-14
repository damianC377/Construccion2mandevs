package app.infrastructure.persistence.mapper;

import app.domain.model.*;
import app.infrastructure.persistence.entities.*;

public class OrderMapper {

    // ======== De dominio a entidad ========
    public static OrderEntity toEntity(Order order) {
        if (order == null) return null;

        // 🔹 Detecta el tipo de orden en tiempo de ejecución
        if (order instanceof MedicationOrder medOrder) {
            MedicationOrderEntity entity = new MedicationOrderEntity();
            entity.setOrderNumber(order.getOrderNumber());
            entity.setItmNumber(order.getItemNumber());
            entity.setCost(order.getCost());
            entity.setDosage(medOrder.getDosage());
            entity.setTreatmentDuration(medOrder.getTreatmentDuration());
            entity.setMedication(MedicationInventoryMapper.toEntity(medOrder.getMedication()));
            return entity;

        } else if (order instanceof ProcedureOrder procOrder) {
            ProcedureOrderEntity entity = new ProcedureOrderEntity();
            entity.setOrderNumber(order.getOrderNumber());
            entity.setItmNumber(order.getItemNumber());
            entity.setCost(order.getCost());
            entity.setQuantity(procOrder.getQuantity());
            entity.setFrequency(procOrder.getFrequency());
            entity.setRequiresSpecialist(procOrder.isRequiresSpecialist());
            entity.setSpecialist(procOrder.getSpecialist());
            entity.setProcedure(ProcedureInventoryMapper.toEntity(procOrder.getProcedure()));
            return entity;

        } else if (order instanceof DiagnosticTestOrder diagOrder) {
            DiagnosticTestOrderEntity entity = new DiagnosticTestOrderEntity();
            entity.setOrderNumber(order.getOrderNumber());
            entity.setItmNumber(order.getItemNumber());
            entity.setCost(order.getCost());
            entity.setQuantity(diagOrder.getQuantity());
            entity.setRequiresSpecialist(diagOrder.isRequiresSpecialist());
            entity.setSpecialist(diagOrder.getSpecialist());
            entity.setDiagnosticTestInventory(DiagnosticTestInventoryMapper.toEntity(diagOrder.getDiagnosticTestInventory()));
            return entity;
        }

        return null; // Si no coincide con ningún tipo conocido
    }

    // ======== De entidad a dominio ========
    public static Order toDomain(OrderEntity entity) {
        if (entity == null) return null;

        // 🔹 Detecta el tipo de entidad real
        if (entity instanceof MedicationOrderEntity medEntity) {
            MedicationOrder order = new MedicationOrder();
            order.setOrderNumber(medEntity.getOrderNumber());
            order.setItemNumber(medEntity.getItmNumber());
            order.setCost(medEntity.getCost());
            order.setDosage(medEntity.getDosage());
            order.setTreatmentDuration(medEntity.getTreatmentDuration());
            order.setMedication(MedicationInventoryMapper.toDomain(medEntity.getMedication()));
            return order;

        } else if (entity instanceof ProcedureOrderEntity procEntity) {
            ProcedureOrder order = new ProcedureOrder();
            order.setOrderNumber(procEntity.getOrderNumber());
            order.setItemNumber(procEntity.getItmNumber());
            order.setCost(procEntity.getCost());
            order.setQuantity(procEntity.getQuantity());
            order.setFrequency(procEntity.getFrequency());
            order.setRequiresSpecialist(procEntity.isRequiresSpecialist());
            order.setSpecialist(procEntity.getSpecialist());
            order.setProcedure(ProcedureInventoryMapper.toDomain(procEntity.getProcedure()));
            return order;

        } else if (entity instanceof DiagnosticTestOrderEntity diagEntity) {
            DiagnosticTestOrder order = new DiagnosticTestOrder();
            order.setOrderNumber(diagEntity.getOrderNumber());
            order.setItemNumber(diagEntity.getItmNumber());
            order.setCost(diagEntity.getCost());
            order.setQuantity(diagEntity.getQuantity());
            order.setRequiresSpecialist(diagEntity.isRequiresSpecialist());
            order.setSpecialist(diagEntity.getSpecialist());
            order.setDiagnosticTestInventory(DiagnosticTestInventoryMapper.toDomain(diagEntity.getDiagnosticTestInventory()));
            return order;
        }

        return null; // Si no se reconoce el tipo
    }
}
