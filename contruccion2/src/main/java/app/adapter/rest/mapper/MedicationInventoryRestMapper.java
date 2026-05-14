package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.MedicationInventoryBuilder;
import app.adapter.rest.request.MedicationInventoryRequest;
import app.adapter.rest.response.MedicationInventoryResponse;
import app.domain.model.MedicationInventory;

@Component
public class MedicationInventoryRestMapper {

    @Autowired
    private MedicationInventoryBuilder medicationInventoryBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public MedicationInventory toDomain(MedicationInventoryRequest req) throws Exception {
        return medicationInventoryBuilder.build(
                req.getName(),
                req.getCost()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public MedicationInventoryResponse toResponse(MedicationInventory med) {
        MedicationInventoryResponse res = new MedicationInventoryResponse();
        res.setId(med.getId());
        res.setName(med.getName());
        res.setCost(med.getCost());
        return res;
    }
}
