package app.domain.port;

import app.domain.model.Invoice;



public interface InvoicePort {
    //Crea la factura
    public void createInvoice(Invoice invoice) throws Exception;

    //Guarda la factura
    public void save(Invoice invoice) throws Exception;
    
}
