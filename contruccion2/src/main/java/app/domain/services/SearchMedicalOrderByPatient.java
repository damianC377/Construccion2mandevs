
package app.domain.services;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.MedicalOrderPort;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchMedicalOrderByPatient {
    @Autowired
    private MedicalOrderPort medicalOrderPort;
    @Autowired
    private PatientPort patientPort;

    // Consultar las órdenes médicas de un paciente
    public List<MedicalOrder> search(Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        List<MedicalOrder> orders = medicalOrderPort.findByPatient(patient);
        if (orders == null || orders.isEmpty()) {
            throw new Exception("El paciente no tiene órdenes médicas registradas");
        }
        
        requireAnyRole(Role.NURSE, Role.DOCTOR);
        
        return orders;
    }

    private void requireAnyRole(Role... roles) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        boolean ok = false;
        for (Role r : roles) {
            String needed = "ROLE_" + r.name();
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed))) {
                ok = true; break;
            }
        }
        if (!ok) throw new BusinessException("Acceso denegado");
    }

}
