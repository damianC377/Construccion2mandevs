package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.enums.Role;
import app.domain.port.DiagnosticTestInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDiagnosticTestInventory {
    @Autowired
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;
    @Autowired
    private UserRequireRole userRequireRole;

    public void create(DiagnosticTestInventory diagnosticTest) throws Exception {
        // Validar rol
        userRequireRole.requireRole(Role.SUPPORT);

        // Validar que no esté vacío
        if (diagnosticTest == null || diagnosticTest.getName() == null) {
            throw new Exception("El nombre del test diagnóstico es obligatorio");
        }

        // Validar costo
        if (diagnosticTest.getCost() <= 0) {
            throw new Exception("El costo debe ser mayor que cero");
        }

        // Validar duplicados
        DiagnosticTestInventory existing = diagnosticTestInventoryPort.findById(diagnosticTest);
        if (existing != null) {
            throw new BusinessException("El test diagnóstico ya está registrado en el inventario");
        }

        // Guardar en inventario
        diagnosticTestInventoryPort.save(diagnosticTest);
    }
}
