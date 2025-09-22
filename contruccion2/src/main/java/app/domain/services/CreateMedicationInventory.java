package app.domain.services;

import app.domain.model.MedicationInventory;
import app.domain.model.enums.Role;
import app.domain.port.MedicationInventoryPort;

public class CreateMedicationInventory {

    private UserRequireRole userRequireRole;
    private MedicationInventoryPort medicationInventoryPort;

    public void create(MedicationInventory medication) throws Exception {
        // Validar rol
        userRequireRole.requireRole(Role.SUPPORT);

        // Validar que no esté vacío
        if (medication == null || medication.getName() == null) {
            throw new Exception("El nombre del medicamento es obligatorio");
        }

        // Validar costo
        if (medication.getCost() <= 0) {
            throw new Exception("El costo debe ser mayor que cero");
        }

        // Validar duplicados
        MedicationInventory existing = medicationInventoryPort.findById(medication);
        if (existing != null) {
            throw new Exception("El medicamento ya está registrado en el inventario");
        }

        // Guardar en inventario
        medicationInventoryPort.save(medication);
    }

}
