package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.enums.Role;
import app.domain.port.InvoicePort;


public class InvoiceService {
    private InvoicePort invoicePort;

    //Crear Factura
    public void createInvoice(Invoice invoice) throws Exception{
        //Validando que no este vacia
        if(invoice == null){
            throw new Exception("La factura no puede estar vacia ");
        }

        if(invoice.getDoctor().getRole() != Role.ADMINISTRATIVE_STAFF){
            throw new Exception("Solo personal autorizado");
        }

        //Validando que este el paciente asociado
        if(invoice.getPatient() == null){
            throw new Exception("La factura debe tener un paciente asociado");
        }
        //Validando que este el doctor asignado
        if(invoice.getDoctor() == null){
            throw new Exception("La factura debe tener un doctor asignado");
        }
        //Validando que tenga orden medica asociada
        if(invoice.getMedicalOrder() == null){
            throw new Exception("La factura debe tener una orden medica asociada");           
    }
        //Factura Guardada
        invoicePort.save(invoice);
        System.out.println("La factura fue creada correctame");
    }
}