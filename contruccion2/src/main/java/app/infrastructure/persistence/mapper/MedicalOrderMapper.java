package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalOrder;
import app.infrastructure.persistence.entities.MedicalOrderEntity;
import java.util.stream.Collectors;

public class MedicalOrderMapper {

    public static MedicalOrderEntity toEntity(MedicalOrder medicalOrder) {
        if (medicalOrder == null) return null;
        MedicalOrderEntity medicalOrderEntity = new MedicalOrderEntity();
        medicalOrderEntity.setOrderNumber(medicalOrder.getOrderNumber());
        medicalOrderEntity.setPatient(PatientMapper.toEntity(medicalOrder.getPatient()));
        medicalOrderEntity.setDoctor(UserMapper.toEntity(medicalOrder.getDoctor()));
        medicalOrderEntity.setOrderDate(medicalOrder.getOrderDate());

        if (medicalOrder.getItems() != null) {
            medicalOrderEntity.setItems(medicalOrder.getItems().stream()
                    .map(OrderMapper::toEntity)
                    .collect(Collectors.toList());
        }

        return medicalOrderEntity;
    }
}
