package app.adapter.in.builder;

import app.adapter.in.validators.ProcedureOrderValidator;
import app.domain.model.ProcedureInventory;
import app.domain.model.ProcedureOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderBuilder {

    @Autowired
    private ProcedureOrderValidator procedureOrderValidator;

    @Autowired
    private OrderBuilder orderBuilder;

    public ProcedureOrder build(
            String orderNumber,
            String itemNumber,
            String cost,
            String procedureInventoryId,
            String quantity,
            String frequency,
            String requiresSpecialist,
            String specialist

    ) throws Exception{

        ProcedureOrder order = orderBuilder.build(new ProcedureOrder(), orderNumber,itemNumber , cost);

        ProcedureInventory procedureInventory = new ProcedureInventory();
        procedureInventory.setId(procedureOrderValidator.procedureInventoryIdValidator(procedureInventoryId));
        order.setProcedure(procedureInventory);

        order.setQuantity(procedureOrderValidator.quantityValidator(quantity));
        order.setFrequency(procedureOrderValidator.frequencyValidator(frequency));
        order.setRequiresSpecialist(procedureOrderValidator.requiresSpecialistValidator(requiresSpecialist));
        order.setSpecialist(procedureOrderValidator.specialistValidator(specialist));

        return order;
    }
}
