package app.domain.port;

import app.domain.model.MedicationInventory;

public interface MedicationInventoryPort {

    // Encontrar medicamento por id
    public MedicationInventory findById(MedicationInventory medication) throws Exception;

    // Guardar medicamento
    public void save(MedicationInventory medication) throws Exception;
}
