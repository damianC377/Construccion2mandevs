package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;

public class CreatePatientService {


    private PatientPort patientPort;
    private UserRequireRoleService userRequireRole;

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
