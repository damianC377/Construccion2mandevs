package app.domain.services;

import app.domain.model.DiagnosticTestInventory;
import app.domain.model.enums.Role;
import app.domain.port.DiagnosticTestInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchDiagnosticTestInventoryById {
    @Autowired
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;

    // Buscar test diagnóstico en inventario
    public DiagnosticTestInventory search(DiagnosticTestInventory diagnosticTest) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

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
