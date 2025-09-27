package app.adapter.in.builder;

import app.adapter.in.validators.InvoiceValidator;
import app.domain.model.*;

public class InvoiceBuilder {

    private InvoiceValidator invoiceValidator;

    public Invoice build(String policyNumber, String policyValidityDays, String policyEndDate) throws Exception {

        Invoice invoice = new Invoice();
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidityDays(invoiceValidator.policyValidityDaysValidator(policyValidityDays));
        invoice.setPolicyEndDate(invoiceValidator.policyEndDateValidator(policyEndDate));

        return invoice;
    }
}
