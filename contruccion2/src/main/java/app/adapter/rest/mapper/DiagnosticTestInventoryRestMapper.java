package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.DiagnosticTestInventoryBuilder;
import app.adapter.rest.request.DiagnosticTestInventoryRequest;
import app.adapter.rest.response.DiagnosticTestInventoryResponse;
import app.domain.model.DiagnosticTestInventory;

@Component
public class DiagnosticTestInventoryRestMapper {

    @Autowired
    private DiagnosticTestInventoryBuilder diagnosticTestInventoryBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public DiagnosticTestInventory toDomain(DiagnosticTestInventoryRequest req) throws Exception {
        return diagnosticTestInventoryBuilder.build(
                req.getName(),
                req.getCost()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public DiagnosticTestInventoryResponse toResponse(DiagnosticTestInventory test) {
        DiagnosticTestInventoryResponse res = new DiagnosticTestInventoryResponse();
        res.setId(test.getId());
        res.setName(test.getName());
        res.setCost(test.getCost());
        return res;
    }
}
