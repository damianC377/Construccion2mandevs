package app.adapter.rest.mapper;

import app.adapter.in.builder.DiagnosticTestOrderBuilder;
import app.adapter.rest.request.DiagnosticTestOrderRequest;
import app.adapter.rest.response.DiagnosticTestOrderResponse;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.DiagnosticTestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticTestOrderRestMapper {

    @Autowired
    private DiagnosticTestOrderBuilder diagnosticTestOrderBuilder;

    /**
     * Convierte el request del cliente en un modelo del dominio (usa el builder).
     */
    public DiagnosticTestOrder toDomain(DiagnosticTestOrderRequest req) throws Exception {
        return diagnosticTestOrderBuilder.build(
                req.getOrderNumber(),
                req.getItemNumber(),
                req.getCost(),
                req.getDiagnosticTestInventoryId(),
                req.getQuantity(),
                req.getRequiresSpecialist(),
                req.getSpecialist()
        );
    }

    /**
     * Convierte un modelo del dominio a un objeto de respuesta JSON.
     */
    public DiagnosticTestOrderResponse toResponse(DiagnosticTestOrder order) {
        DiagnosticTestOrderResponse res = new DiagnosticTestOrderResponse();

        res.setItemNumber(order.getItemNumber());
        res.setCost(order.getCost());
        res.setQuantity(order.getQuantity());
        res.setRequiresSpecialist(order.isRequiresSpecialist());
        res.setSpecialist(order.getSpecialist());

        DiagnosticTestInventory diagnosticInventory = order.getDiagnosticTestInventory();
        if (diagnosticInventory != null) {
            res.setDiagnosticTestInventoryId(diagnosticInventory.getId());
            res.setDiagnosticTestName(diagnosticInventory.getName());
        }

        return res;
    }
}
