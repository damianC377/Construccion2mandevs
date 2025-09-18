package app.domain.services;

import java.util.List;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.port.InvoicePort;
import app.domain.port.PatientPort;

public class InvoiceGetByPatientService {
	
	private InvoicePort invoicePort;
	private PatientPort patientPort;
	
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
