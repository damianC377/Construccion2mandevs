package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.HealthInsuranceBuilder;
import app.adapter.rest.request.HealthInsuranceRequest;
import app.adapter.rest.response.HealthInsuranceResponse;
import app.domain.model.HealthInsurance;

@Component
public class HealthInsuranceRestMapper {

    @Autowired
    private HealthInsuranceBuilder healthInsuranceBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public HealthInsurance toDomain(HealthInsuranceRequest req) throws Exception {
        return healthInsuranceBuilder.build(
                req.getCompanyName(),
                req.getPolicyNumber(),
                req.getActive(),
                req.getEndDate()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public HealthInsuranceResponse toResponse(HealthInsurance insurance) {
        HealthInsuranceResponse res = new HealthInsuranceResponse();
        res.setCompanyName(insurance.getCompanyName());
        res.setPolicyNumber(insurance.getPolicyNumber());
        res.setActive(insurance.isActive());
        res.setEndDate(insurance.getEndDate());
        return res;
    }
}
