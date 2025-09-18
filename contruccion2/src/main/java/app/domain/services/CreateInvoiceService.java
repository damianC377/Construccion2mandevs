package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.InvoicePort;
import app.domain.port.PatientPort;



public class CreateInvoiceService {
    private InvoicePort invoicePort;
    private PatientPort patientPort;
    private UserRequireRoleService userRequireRole;


    //Crear Factura
    public void createInvoice(Invoice invoice) throws Exception{
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }

        // Validar de que exista un paciente
        Patient patient = patientPort.findByDocument(invoice.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar personal
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        //Validando que este el doctor asignado
        if(invoice.getDoctor() == null){
            throw new Exception("La factura debe tener un doctor asignado");
        }
        //Validando que tenga orden medica asociada
        if(invoice.getMedicalOrder() == null){
            throw new Exception("La factura debe tener una orden medica asociada");           
        }

        invoice.setPatient(patient);
        //Factura Guardada
        invoicePort.save(invoice);
    }
   
}