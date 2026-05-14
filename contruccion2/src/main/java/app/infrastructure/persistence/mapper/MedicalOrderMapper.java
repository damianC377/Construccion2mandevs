package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalOrder;
import app.infrastructure.persistence.entities.MedicalOrderEntity;

public class MedicalOrderMapper {

    /**
     * Convierte un objeto del dominio (MedicalOrder) a una entidad (MedicalOrderEntity)
     * para ser almacenado en la base de datos.
     */
    public static MedicalOrderEntity toEntity(MedicalOrder medicalOrder) {
        if (medicalOrder == null) return null;

        MedicalOrderEntity entity = new MedicalOrderEntity();
        entity.setOrderNumber(medicalOrder.getOrderNumber());
        entity.setPatient(PatientMapper.toEntity(medicalOrder.getPatient()));
        entity.setDoctor(UserMapper.toEntity(medicalOrder.getDoctor()));
        entity.setOrderDate(medicalOrder.getOrderDate());

        // 🔹 Convierte los ítems (subórdenes) con el nuevo OrderMapper
        if (medicalOrder.getItems() != null && !medicalOrder.getItems().isEmpty()) {
            entity.setItems(
                    medicalOrder.getItems().stream()
                            .map(OrderMapper::toEntity)
                            .toList()
            );
        }

        return entity;
    }

    /**
     * Convierte una entidad (MedicalOrderEntity) desde la base de datos
     * a un objeto del dominio (MedicalOrder).
     */
    public static MedicalOrder toDomain(MedicalOrderEntity entity) {
        if (entity == null) return null;

        MedicalOrder medicalOrder = new MedicalOrder();
        medicalOrder.setOrderNumber(entity.getOrderNumber());
        medicalOrder.setPatient(PatientMapper.toDomain(entity.getPatient()));
        medicalOrder.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        medicalOrder.setOrderDate(entity.getOrderDate());

        // 🔹 Reconstruye los ítems con sus tipos correctos (medicamento, procedimiento, diagnóstico)
        if (entity.getItems() != null && !entity.getItems().isEmpty()) {
            medicalOrder.setItems(
                    entity.getItems().stream()
                            .map(OrderMapper::toDomain)
                            .toList()
            );
        }

        return medicalOrder;
    }
}
