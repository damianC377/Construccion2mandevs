package app.domain.port;

import app.domain.model.Invoice;
import app.domain.model.Patient;

import java.util.List;


public interface InvoicePort {
    //Crea la factura
    public void createInvoice(Invoice invoice) throws Exception;

    //Guarda la factura
    public void save(Invoice invoice) throws Exception;

    // Consultar facturas por paciente
    List<Invoice> findByPatient(Patient patient);


}
