package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;

public class HealthInsuranceService {

    private PatientPort patientPort;
    private HealthInsurancePort healthInsurancePort;
    private UserPort userPort;

    // Crear seguro de salud
    public void create(HealthInsurance healthInsurance, Patient patient, User administrativeStaff) throws Exception {
        // Validar si el paciente existe
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        // Validar que lo registre personal administrativo
        if (administrativeStaff == null || !administrativeStaff.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("El seguro solo puede ser registrado por personal administrativo");
        }

        // Validar que el paciente no tenga seguro registrado
        if (patient.getHealthInsurance() != null) {
            throw new Exception("Este paciente ya tiene un seguro registrado");
        }

        // Asociar seguro al paciente
        patient.setHealthInsurance(healthInsurance);

        // Guardar seguro
        healthInsurancePort.save(healthInsurance);
    }

    // Actualizar seguro de salud
    public void update(HealthInsurance healthInsurance, Patient patient) throws Exception {
        // Validar si el paciente existe y tiene seguro
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }

        // Actualizar seguro
        healthInsurancePort.update(healthInsurance);
    }

    // Consultar seguro de salud por paciente
    public HealthInsurance getByPatient(Patient patient) throws Exception {
        // Validar si el paciente existe y tiene seguro
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }


        return patient.getHealthInsurance();
    }
}
