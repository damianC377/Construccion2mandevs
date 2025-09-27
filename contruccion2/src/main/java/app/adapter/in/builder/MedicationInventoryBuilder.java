package app.adapter.in.builder;

import app.adapter.in.validators.MedicationInventoryValidator;
import app.domain.model.MedicationInventory;

public class MedicationInventoryBuilder {

    private MedicationInventoryValidator medicationInventoryValidator;

    public MedicationInventory build(String id, String name, String cost) throws Exception {

        MedicationInventory medicationInventory = new MedicationInventory();
        medicationInventory.setId(medicationInventoryValidator.idValidator(id));
        medicationInventory.setName(medicationInventoryValidator.nameValidator(name));
        medicationInventory.setCost(medicationInventoryValidator.costValidator(cost));

        return medicationInventory;
    }
}

