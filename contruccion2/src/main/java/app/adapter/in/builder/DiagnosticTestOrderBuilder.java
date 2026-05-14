package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticTestOrderValidator;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.DiagnosticTestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticTestOrderBuilder {

    @Autowired
    private DiagnosticTestOrderValidator diagnosticTestOrderValidator;

    @Autowired
    private OrderBuilder orderBuilder;

    public DiagnosticTestOrder build(
            String orderNumber,
            String itemNumber,
            String cost,
            String diagnosticTestInventoryId,
            String quantity,
            String requiresSpecialist,
            String specialist
    ) throws Exception {

        DiagnosticTestOrder order = orderBuilder.build(new DiagnosticTestOrder(), orderNumber, itemNumber, cost);

        DiagnosticTestInventory diagnosticTestInventory = new DiagnosticTestInventory();
        // asigna el inventario (ya validado antes o recuperado de BD)
        diagnosticTestInventory.setId(diagnosticTestOrderValidator.diagnosticTestInventoryIdValidator(diagnosticTestInventoryId));
        order.setDiagnosticTestInventory(diagnosticTestInventory);

        // valida y convierte los demás campos
        order.setQuantity(diagnosticTestOrderValidator.quantityValidator(quantity));
        order.setRequiresSpecialist(diagnosticTestOrderValidator.requiresSpecialistValidator(requiresSpecialist));
        order.setSpecialist(diagnosticTestOrderValidator.specialistValidator(specialist));

        return order;
    }
}