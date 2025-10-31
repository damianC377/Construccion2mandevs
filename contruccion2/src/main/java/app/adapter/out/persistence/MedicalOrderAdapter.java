package app.adapter.out.persistence;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.port.MedicalOrderPort;
import app.infrastructure.persistence.entities.MedicalOrderEntity;
import app.infrastructure.persistence.mapper.MedicalOrderMapper;
import app.infrastructure.persistence.repository.MedicalOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalOrderAdapter implements MedicalOrderPort {

    @Autowired
    private MedicalOrderRepository medicalOrderRepository;

    @Override
    public void create(MedicalOrder order) throws Exception {
        medicalOrderRepository.save(MedicalOrderMapper.toEntity(order));
    }

    @Override
    public void save(MedicalOrder order) throws Exception {
        medicalOrderRepository.save(MedicalOrderMapper.toEntity(order));
    }

    @Override
    public List<MedicalOrder> findByPatient(Patient patient) {
        List<MedicalOrderEntity> entities = medicalOrderRepository.findByPatientId(patient.getId());
        return entities.stream()
                .map(MedicalOrderMapper::toDomain)
                .toList();
    }

    @Override
    public MedicalOrder findByOrderNumber(long orderNumber) {
        MedicalOrderEntity entity = medicalOrderRepository.findByOrderNumber(orderNumber);
        return MedicalOrderMapper.toDomain(entity);
    }
}
