package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ProcedureInventory;
import app.domain.port.ProcedureInventoryPort;
import app.infrastructure.persistence.entities.ProcedureInventoryEntity;
import app.infrastructure.persistence.mapper.ProcedureInventoryMapper;
import app.infrastructure.persistence.repository.ProcedureInventoryRepository;

@Service
public class ProcedureInventoryAdapter implements ProcedureInventoryPort {

    @Autowired
    private ProcedureInventoryRepository procedureInventoryRepository;

    @Override
    public ProcedureInventory findById(ProcedureInventory procedure) throws Exception {
        // Buscar por ID
        ProcedureInventoryEntity entity = procedureInventoryRepository.findById(procedure.getId());
        // Conversión de entidad a dominio
        return ProcedureInventoryMapper.toDomain(entity);
    }

    @Override
    public void save(ProcedureInventory procedure) throws Exception {
        // Conversión de dominio a entidad
        ProcedureInventoryEntity entity = ProcedureInventoryMapper.toEntity(procedure);
        // Guardar en base de datos
        procedureInventoryRepository.save(entity);
    }
}
