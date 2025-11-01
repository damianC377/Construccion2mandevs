package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.ProcedureInventoryBuilder;
import app.adapter.rest.request.ProcedureInventoryRequest;
import app.adapter.rest.response.ProcedureInventoryResponse;
import app.domain.model.ProcedureInventory;

@Component
public class ProcedureInventoryRestMapper {

    @Autowired
    private ProcedureInventoryBuilder procedureInventoryBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public ProcedureInventory toDomain(ProcedureInventoryRequest req) throws Exception {
        return procedureInventoryBuilder.build(
                req.getName(),
                req.getCost()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public ProcedureInventoryResponse toResponse(ProcedureInventory proc) {
        ProcedureInventoryResponse res = new ProcedureInventoryResponse();
        res.setId(proc.getId());
        res.setName(proc.getName());
        res.setCost(proc.getCost());
        return res;
    }
}
