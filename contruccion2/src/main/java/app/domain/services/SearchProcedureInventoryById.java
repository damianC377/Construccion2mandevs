package app.domain.services;

import app.domain.model.ProcedureInventory;
import app.domain.model.enums.Role;
import app.domain.port.ProcedureInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchProcedureInventoryById {
    @Autowired
    private ProcedureInventoryPort procedureInventoryPort;
    @Autowired
    private UserRequireRole userRequireRole;

    // Buscar procedimiento en inventario
    public ProcedureInventory search(ProcedureInventory procedure) throws Exception {
        // Validar rol
        userRequireRole.requireRole(Role.SUPPORT);

        // Validar que no esté vacío
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

}
