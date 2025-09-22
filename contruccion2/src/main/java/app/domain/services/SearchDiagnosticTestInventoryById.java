package app.domain.services;

import app.domain.model.DiagnosticTestInventory;
import app.domain.model.enums.Role;
import app.domain.port.DiagnosticTestInventoryPort;

public class SearchDiagnosticTestInventoryById {

    private UserRequireRole userRequireRole;
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;

    // Buscar test diagnóstico en inventario
    public DiagnosticTestInventory search(DiagnosticTestInventory diagnosticTest) throws Exception {
        // Validar rol
        userRequireRole.requireRole(Role.SUPPORT);

        // Validar que no esté vacío
        if (diagnosticTest == null || diagnosticTest.getName() == null) {
            throw new Exception("El test diagnóstico es obligatorio");
        }

        // Buscar en inventario
        DiagnosticTestInventory diagnosticTestFound = diagnosticTestInventoryPort.findById(diagnosticTest);
        if (diagnosticTestFound == null) {
            throw new Exception("No se encontró el test diagnóstico: " + diagnosticTest.getName());
        }

        return diagnosticTestFound;
    }
}
