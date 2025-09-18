package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import app.domain.port.PatientPort;


public class CreateHealthInsuranceService {

    private PatientPort patientPort;
    private HealthInsurancePort healthInsurancePort;
    private UserRequireRoleService userRequireRole;

    // Crear seguro de salud
    public void create(HealthInsurance healthInsurance, Patient patient) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que lo registre personal administrativo
        userRequireRole.requireRole(Role.ADMINISTRATIVE_STAFF);

        // Validar que el paciente no tenga seguro registrado
        if (patient.getHealthInsurance() != null) {
            throw new Exception("Este paciente ya tiene un seguro registrado");
        }

        // Asociar seguro al paciente
        patient.setHealthInsurance(healthInsurance);

        healthInsurancePort.save(healthInsurance);
    }

}
