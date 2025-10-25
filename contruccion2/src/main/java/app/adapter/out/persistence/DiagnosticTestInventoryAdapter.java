package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticTestInventory;
import app.domain.port.DiagnosticTestInventoryPort;
import app.infrastructure.persistence.entities.DiagnosticTestInventoryEntity;
import app.infrastructure.persistence.mapper.DiagnosticTestInventoryMapper;
import app.infrastructure.persistence.repository.DiagnosticTestInventoryRepository;

@Service
public class DiagnosticTestInventoryAdapter implements DiagnosticTestInventoryPort {

    @Autowired
    private DiagnosticTestInventoryRepository diagnosticTestInventoryRepository;

    @Override
    public DiagnosticTestInventory findById(DiagnosticTestInventory diagnosticTest) throws Exception {
        // Buscar por ID
        DiagnosticTestInventoryEntity entity = diagnosticTestInventoryRepository.findById(diagnosticTest.getId());
        // Conversión de entidad a dominio
        return DiagnosticTestInventoryMapper.toDomain(entity);
    }

    @Override
    public void save(DiagnosticTestInventory diagnosticTest) {
        // Conversión de dominio a entidad
        DiagnosticTestInventoryEntity entity = DiagnosticTestInventoryMapper.toEntity(diagnosticTest);
        // Guardar en base de datos
        diagnosticTestInventoryRepository.save(entity);
    }
}
