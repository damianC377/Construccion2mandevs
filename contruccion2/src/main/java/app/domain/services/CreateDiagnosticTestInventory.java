package app.domain.services;

import app.domain.model.DiagnosticTestInventory;
import app.domain.model.enums.Role;
import app.domain.port.DiagnosticTestInventoryPort;

public class CreateDiagnosticTestInventory {
    private UserRequireRole userRequireRole;
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;

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
            throw new Exception("El test diagnóstico ya está registrado en el inventario");
        }

        // Guardar en inventario
        diagnosticTestInventoryPort.save(diagnosticTest);
    }
}
