package app.domain.services;

import app.domain.model.ProcedureInventory;
import app.domain.model.enums.Role;
import app.domain.port.ProcedureInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchProcedureInventoryById {

    @Autowired
    private ProcedureInventoryPort procedureInventoryPort;

    // Buscar procedimiento en inventario
    public ProcedureInventory search(ProcedureInventory procedure) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

        // Validar que no este vacio
        if (procedure == null || procedure.getName() == null) {
            throw new Exception("El procedimiento es obligatorio");
        }

        // Buscar en inventario
        ProcedureInventory procedureFound = procedureInventoryPort.findById(procedure);
        if (procedureFound == null) {
            throw new Exception("No se encontró el procedimiento: " + procedure.getName());
        }

        return procedureFound;
    }

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }
}
