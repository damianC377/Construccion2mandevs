package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.rest.request.InvoiceRequest;
import app.adapter.rest.response.InvoiceResponse;
import app.domain.model.Invoice;
import app.domain.model.User;

@Component
public class InvoiceRestMapper {

    @Autowired
    private InvoiceBuilder invoiceBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public Invoice toDomain(InvoiceRequest req) throws Exception {
        return invoiceBuilder.build(
                req.getPatientDocument(),
                req.getDoctorDocument(),
                req.getPolicyNumber(),
                req.getPolicyValidityDays(),
                req.getPolicyEndDate(),
                req.getHealthInsurancePolicyNumber(),
                req.getMedicalOrderId(),
                null // Se deja nulo temporalmente si los items no vienen desde el request
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public InvoiceResponse toResponse(Invoice invoice) {
        InvoiceResponse res = new InvoiceResponse();
        res.setId(invoice.getId());

        // Se validan las relaciones antes de asignar valores para garantizar que no sean nulas.
        res.setPatientDocument(invoice.getPatient() != null ? invoice.getPatient().getDocument() : 0);
        res.setDoctor(invoice.getDoctor() != null ? invoice.getDoctor() : new User());
        res.setHealthInsurancePolicyNumber(invoice.getInsurance() != null ? invoice.getInsurance().getPolicyNumber() : 0);
        res.setPolicyNumber(invoice.getPolicyNumber());
        res.setPolicyValidityDays(invoice.getPolicyValidityDays());
        res.setPolicyEndDate(invoice.getPolicyEndDate());
        res.setMedicalOrderId(invoice.getMedicalOrder() != null ? invoice.getMedicalOrder().getId() : 0);

        return res;
    }
}
