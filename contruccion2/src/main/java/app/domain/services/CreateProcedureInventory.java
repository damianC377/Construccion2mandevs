package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.ProcedureInventory;
import app.domain.model.enums.Role;
import app.domain.port.ProcedureInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CreateProcedureInventory {
    @Autowired
    private ProcedureInventoryPort procedureInventoryPort;

    public void create(ProcedureInventory procedure) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

        // Validar que no esté vacío
        if (procedure == null || procedure.getName() == null) {
            throw new Exception("El nombre del procedimiento es obligatorio");
        }

        // Validar costo
        if (procedure.getCost() <= 0) {
            throw new Exception("El costo debe ser mayor que cero");
        }

        // Validar duplicados
        ProcedureInventory existing = procedureInventoryPort.findById(procedure);
        if (existing != null) {
            throw new BusinessException("El procedimiento ya está registrado en el inventario");
        }

        // Guardar en inventario
        procedureInventoryPort.save(procedure);
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

