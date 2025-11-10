package app.adapter.in.builder;

import app.adapter.in.validators.MedicationOrderValidator;
import app.domain.model.MedicationInventory;
import app.domain.model.MedicationOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicationOrderBuilder {

    @Autowired
    private MedicationOrderValidator medicationOrderValidator;

    @Autowired
    private OrderBuilder orderBuilder;

    public MedicationOrder build(
            String orderNumber,
            String itemNumber,
            String cost,
            String medicationInventoryId,
            String dosage,
            String treatmentDuration
    ) throws Exception {

        // Usa el builder genérico para los atributos comunes
        MedicationOrder order = orderBuilder.build(new MedicationOrder(), orderNumber, itemNumber, cost);

        MedicationInventory medicationInventory = new MedicationInventory();
        medicationInventory.setId(medicationOrderValidator.medicationInventoryIdValidator(medicationInventoryId));
        order.setMedication(medicationInventory);

        order.setDosage(medicationOrderValidator.dosageValidator(dosage));

        order.setTreatmentDuration(medicationOrderValidator.treatmentDurationValidator(treatmentDuration));

        return order;
    }
}
