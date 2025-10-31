package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.DiagnosticTestOrder;
import app.adapter.rest.request.DiagnosticTestOrderRequest;
import app.adapter.rest.response.DiagnosticTestOrderResponse;

@Component
public class DiagnosticTestOrderRestMapper {

    // Convierte el request JSON al modelo de dominio
    public DiagnosticTestOrder toDomain(DiagnosticTestOrderRequest req) {
        DiagnosticTestOrder order = new DiagnosticTestOrder();
        order.setItemNumber(req.getItemNumber());
        order.setCost(req.getCost());
        order.setQuantity(req.getQuantity());
        order.setRequiresSpecialist(req.isRequiresSpecialist());
        order.setSpecialist(req.getSpecialist());

        DiagnosticTestInventory inventory = new DiagnosticTestInventory();
        inventory.setId(req.getDiagnosticTestInventoryId());
        order.setDiagnosticTestInventory(inventory);

        return order;
    }

    // Convierte el modelo de dominio a un objeto de respuesta JSON
    public DiagnosticTestOrderResponse toResponse(DiagnosticTestOrder order) {
        DiagnosticTestOrderResponse res = new DiagnosticTestOrderResponse();
        res.setItemNumber(order.getItemNumber());
        res.setCost(order.getCost());
        res.setQuantity(order.getQuantity());
        res.setRequiresSpecialist(order.isRequiresSpecialist());
        res.setSpecialist(order.getSpecialist());

        if (order.getDiagnosticTestInventory() != null) {
            res.setDiagnosticTestName(order.getDiagnosticTestInventory().getName());
        }

        return res;
    }
}
