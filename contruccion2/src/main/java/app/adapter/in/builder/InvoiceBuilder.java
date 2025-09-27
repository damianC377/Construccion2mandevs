package app.adapter.in.builder;

import app.adapter.in.validators.InvoiceValidator;
import app.domain.model.*;

public class InvoiceBuilder {

    private final InvoiceValidator invoiceValidator;

    public InvoiceBuilder(InvoiceValidator invoiceValidator) {
        this.invoiceValidator = invoiceValidator;
    }

    public Invoice build(Patient patient, User doctor, HealthInsurance insurance,
                         String policyNumber, String policyValidityDays, String policyEndDate,
                         MedicalOrder medicalOrder) throws Exception {

        Invoice invoice = new Invoice();

        invoice.setPatient(invoiceValidator.patientValidator(patient));
        invoice.setDoctor(invoiceValidator.doctorValidator(doctor));
        invoice.setInsurance(invoiceValidator.insuranceValidator(insurance));
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidityDays(invoiceValidator.policyValidityDaysValidator(policyValidityDays));
        invoice.setPolicyEndDate(invoiceValidator.policyEndDateValidator(policyEndDate));
        invoice.setMedicalOrder(invoiceValidator.medicalOrderValidator(medicalOrder));

        return invoice;
    }
}
