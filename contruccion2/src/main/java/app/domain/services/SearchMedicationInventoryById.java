package app.domain.services;

import app.domain.model.MedicationInventory;
import app.domain.model.enums.Role;
import app.domain.port.MedicationInventoryPort;

public class SearchMedicationInventoryById {

    private UserRequireRole userRequireRole;
    private MedicationInventoryPort medicationInventoryPort;

    // Buscar medicamento en inventario
    public MedicationInventory search(MedicationInventory medication) throws Exception {
        // Validar rol
        userRequireRole.requireRole(Role.SUPPORT);

        // Validar que no este vacio
        if (medication == null || medication.getName() == null) {
            throw new Exception("El medicamento es obligatorio");
        }

        // Buscar en inventario
        MedicationInventory medicationFound = medicationInventoryPort.findById(medication);
        if (medicationFound == null) {
            throw new Exception("No se encontró el medicamento: " + medication.getName());
        }

        return medicationFound;
    }
}
