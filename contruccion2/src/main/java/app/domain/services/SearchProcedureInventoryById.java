package app.domain.services;

import app.domain.model.ProcedureInventory;
import app.domain.model.enums.Role;
import app.domain.port.ProcedureInventoryPort;

public class SearchProcedureInventoryById {

    private UserRequireRole userRequireRole;
    private ProcedureInventoryPort procedureInventoryPort;

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
