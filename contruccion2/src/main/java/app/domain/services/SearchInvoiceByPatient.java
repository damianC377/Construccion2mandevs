package app.domain.services;

import java.util.List;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.InvoicePort;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchInvoiceByPatient {
    @Autowired
    private InvoicePort invoicePort;
    @Autowired
    private PatientPort patientPort;
    
     // Consultar facturas de un paciente
    public List<Invoice> search(Patient patient) throws Exception {
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
        requireRole(Role.ADMINISTRATIVE_STAFF);

        return invoices;
    }

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }
}
