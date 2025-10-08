package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePatient {
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private UserRequireRole userRequireRole;

    // Crear paciente
    public void create(Patient patient) throws Exception {
        // Validar que no exista un paciente con el mismo documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient != null) {
            throw new Exception("Este paciente ya fue registrado");
        }
        
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);
        
        patientPort.save(patient);
    }


}
