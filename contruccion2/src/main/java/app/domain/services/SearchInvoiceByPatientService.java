package app.domain.services;

import java.util.List;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.InvoicePort;
import app.domain.port.PatientPort;

public class SearchInvoiceByPatientService {
	
	private InvoicePort invoicePort;
	private PatientPort patientPort;
	private UserRequireRoleService userRequireRole;
	
	 // Consultar facturas de un paciente
    public List<Invoice> getByPatient(Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        List<Invoice> invoices = invoicePort.findByPatient(patient);
        if (invoices == null || invoices.isEmpty()) {
            throw new Exception("El paciente no tiene facturas registradas");
        }
        
     // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        return invoices;
    }
}
