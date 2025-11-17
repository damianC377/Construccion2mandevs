package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.enums.Role;
import app.domain.port.DiagnosticTestInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CreateDiagnosticTestInventory {
    @Autowired
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;

    public void create(DiagnosticTestInventory diagnosticTest) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

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

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }
}
