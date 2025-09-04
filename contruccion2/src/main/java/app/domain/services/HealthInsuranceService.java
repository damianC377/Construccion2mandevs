package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.HealthInsurancePort;
import app.domain.port.PatientPort;

public class HealthInsuranceService {
    private PatientPort patientPort;
    private HealthInsurancePort healthInsurancePort;

    // Crear seguro de salud
    public void createHealthInsurance(HealthInsurance insurance, Patient patient, User user) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }

        if (user == null || !user.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("El seguro solo puede ser registrado por personal administrativo");
        }

        if (patient.getHealthInsurance() != null) {
            throw new Exception("Este paciente ya tiene un seguro registrado");
        }

        healthInsurancePort.save(insurance);
    }

    // Actualizar seguro de salud
    public void updateHealthInsurance(HealthInsurance insurance, Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }

        healthInsurancePort.update(insurance);
    }

    // Consultar seguro de salud
    public HealthInsurance getHealthInsurance(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null || patient.getHealthInsurance() == null) {
            throw new Exception("El paciente no tiene seguro registrado");
        }

        return patient.getHealthInsurance();
    }
}
