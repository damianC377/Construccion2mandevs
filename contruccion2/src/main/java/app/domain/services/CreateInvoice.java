package app.domain.services;

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
public class CreateInvoice {
    @Autowired
    private InvoicePort invoicePort;
    @Autowired
    private PatientPort patientPort;


    //Crear Factura
    public void create(Invoice invoice) throws Exception{
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }

        // Validar de que exista un paciente
        Patient patient = patientPort.findByDocument(invoice.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar personal
        requireRole(Role.ADMINISTRATIVE_STAFF);

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