package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicationInventory;
import app.domain.port.MedicationInventoryPort;
import app.infrastructure.persistence.entities.MedicationInventoryEntity;
import app.infrastructure.persistence.mapper.MedicationInventoryMapper;
import app.infrastructure.persistence.repository.MedicationInventoryRepository;

@Service
public class MedicationInventoryAdapter implements MedicationInventoryPort {

    @Autowired
    private MedicationInventoryRepository medicationInventoryRepository;

    @Override
    public MedicationInventory findById(MedicationInventory medication) throws Exception {
        // Buscar por ID
        MedicationInventoryEntity entity = medicationInventoryRepository.findById(medication.getId());
        // Conversión de entidad a dominio
        return MedicationInventoryMapper.toDomain(entity);
    }

    @Override
    public void save(MedicationInventory medication) throws Exception {
        // Conversión de dominio a entidad
        MedicationInventoryEntity entity = MedicationInventoryMapper.toEntity(medication);
        // Guardar en base de datos
        medicationInventoryRepository.save(entity);
    }
}
