package app.adapter.in.builder;

import app.adapter.in.validators.MedicationInventoryValidator;
import app.domain.model.MedicationInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicationInventoryBuilder {

    @Autowired
    private MedicationInventoryValidator medicationInventoryValidator;

    public MedicationInventory build(String name, String cost) throws Exception {

        MedicationInventory medicationInventory = new MedicationInventory();
        medicationInventory.setName(medicationInventoryValidator.nameValidator(name));
        medicationInventory.setCost(medicationInventoryValidator.costValidator(cost));

        return medicationInventory;
    }
}

