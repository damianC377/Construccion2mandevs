package app.adapter.in.builder;

import java.util.List;
import app.adapter.in.validators.InvoiceValidator;
import app.adapter.in.validators.MedicalOrderValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Invoice;
import app.domain.model.MedicalOrder;
import app.domain.model.Order;
import app.domain.model.Patient;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceBuilder {

    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private MedicalOrderValidator medicalOrderValidator;
    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private MedicalOrderBuilder medicalOrderBuilder;

    public Invoice build(String patientDocument, String doctorDocument, String policyNumber, String policyValidityDays, String policyEndDate,
                         String orderNumber, String orderDate, List<Order> items) throws Exception {



        // Crear e inicializar los objetos que componen la entidad

        // Crear MedicalOrder usando su propio builder. Invoice requiere un MedicalOrder completo y validado
        // porque la factura debe reflejar toda la información del pedido médico.
        MedicalOrder medicalOrder = medicalOrderBuilder.build(patientDocument, doctorDocument, orderNumber, orderDate, items);

        Patient patient = medicalOrder.getPatient();
        User doctor = medicalOrder.getDoctor();
        Invoice invoice = new Invoice();

        // Validar y asignar los atributos del Invoice
        invoice.setPatient(patient);
        invoice.setDoctor(doctor);
        invoice.setMedicalOrder(medicalOrder);
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidityDays(invoiceValidator.policyValidityDaysValidator(policyValidityDays));
        invoice.setPolicyEndDate(invoiceValidator.policyEndDateValidator(policyEndDate));

        return invoice;
    }
}
