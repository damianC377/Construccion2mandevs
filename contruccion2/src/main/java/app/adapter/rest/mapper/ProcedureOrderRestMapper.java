package app.adapter.rest.mapper;

import app.adapter.in.builder.ProcedureOrderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.domain.model.ProcedureInventory;
import app.domain.model.ProcedureOrder;
import app.adapter.rest.request.ProcedureOrderRequest;
import app.adapter.rest.response.ProcedureOrderResponse;

@Component
public class ProcedureOrderRestMapper {


    @Autowired
    private ProcedureOrderBuilder procedureOrderBuilder;

    // Convierte el request (JSON del cliente) al modelo de dominio
    public ProcedureOrder toDomain(ProcedureOrderRequest req) throws Exception {
        return procedureOrderBuilder.build(
                req.getOrderNumber(),
                req.getItemNumber(),
                req.getCost(),
                req.getProcedureId(),
                req.getQuantity(),
                req.getFrequency(),
                req.getRequiresSpecialist(),
                req.getSpecialist()
        );
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
            ProcedureInventory procedure = order.getProcedure();
            res.setProcedureId(procedure.getId());
            res.setProcedureName(procedure.getName());
        }

        return res;
    }
}
