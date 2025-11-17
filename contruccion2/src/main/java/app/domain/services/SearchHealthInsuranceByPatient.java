package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchHealthInsuranceByPatient {
    @Autowired
    private PatientPort patientPort;
    
       // Consultar seguro de salud por paciente
    public HealthInsurance search(Patient patient) throws Exception {
        //Buscar el paciente
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }
        
        // Validar si el paciente existe y tiene seguro
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }
        
     // Validar que lo registre personal administrativo
        requireRole(Role.ADMINISTRATIVE_STAFF);

        return patient.getHealthInsurance();
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
