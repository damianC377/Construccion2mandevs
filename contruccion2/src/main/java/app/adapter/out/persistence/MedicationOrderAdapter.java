package app.adapter.out.persistence;

import app.domain.model.MedicationOrder;
import app.domain.port.MedicationOrderPort;
import app.infrastructure.persistence.entities.MedicationOrderEntity;
import app.infrastructure.persistence.mapper.MedicationOrderMapper;
import app.infrastructure.persistence.repository.MedicationOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationOrderAdapter implements MedicationOrderPort {

    @Autowired
    private MedicationOrderRepository medicationOrderRepository;

    @Override
    public MedicationOrder findByOrderNumber(long orderNumber) {
        MedicationOrderEntity entity = medicationOrderRepository.findByOrderNumber(orderNumber);
        return MedicationOrderMapper.toDomain(entity);
    }

    @Override
    public void save(MedicationOrder order) {
        medicationOrderRepository.save(MedicationOrderMapper.toEntity(order));
    }
}
