package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.domain.model.ProcedureInventory;
import app.domain.model.ProcedureOrder;
import app.adapter.rest.request.ProcedureOrderRequest;
import app.adapter.rest.response.ProcedureOrderResponse;

@Component
public class ProcedureOrderRestMapper {

    // Convierte el request (JSON del cliente) al modelo de dominio
    public ProcedureOrder toDomain(ProcedureOrderRequest req) {
        ProcedureOrder order = new ProcedureOrder();
        order.setItemNumber(req.getItemNumber());
        order.setCost(req.getCost());
        order.setQuantity(req.getQuantity());
        order.setFrequency(req.getFrequency());
        order.setRequiresSpecialist(req.isRequiresSpecialist());
        order.setSpecialist(req.getSpecialist());

        ProcedureInventory procedure = new ProcedureInventory();
        procedure.setId(req.getProcedureId());

        order.setProcedure(procedure);

        return order;
    }

    // Convierte el modelo de dominio a un objeto de respuesta JSON
    public ProcedureOrderResponse toResponse(ProcedureOrder order) {
        ProcedureOrderResponse res = new ProcedureOrderResponse();
        res.setItemNumber(order.getItemNumber());
        res.setCost(order.getCost());
        res.setQuantity(order.getQuantity());
        res.setFrequency(order.getFrequency());
        res.setRequiresSpecialist(order.isRequiresSpecialist());
        res.setSpecialist(order.getSpecialist());

        if (order.getProcedure() != null) {
            res.setProcedureName(order.getProcedure().getName());
        }

        return res;
    }
}
