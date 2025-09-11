package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.model.User;
import app.domain.port.InvoicePort;
import app.domain.port.PatientPort;

import java.util.List;


public class InvoiceService {
    private InvoicePort invoicePort;
    private PatientPort patientPort;


    //Crear Factura
    public void createInvoice(Invoice invoice, User adminUser) throws Exception{
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }

        // Validar de que exista un paciente
        Patient patient = patientPort.findByDocument(invoice.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar personal
        if (adminUser == null || adminUser.getRole() != Role.ADMINISTRATIVE_STAFF) {
            throw new Exception("Solo personal administrativo puede crear facturas");
        }

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
    // Consultar facturas de un paciente
    public List<Invoice> getByPatient(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        List<Invoice> invoices = invoicePort.findByPatient(patient);
        if (invoices == null || invoices.isEmpty()) {
            throw new Exception("El paciente no tiene facturas registradas");
        }

        return invoices;
    }
}