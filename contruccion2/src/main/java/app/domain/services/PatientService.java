package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;

public class PatientService {
    private UserPort userPort;
    private PatientPort patientPort;

    // Crear paciente
    public void createPatient(Patient patient, User user) throws Exception {
        // Validación de duplicado: si ya existe otro paciente con el mismo documento
        patient = patientPort.findByDocument(patient);
        if (patient != null) {
            throw new Exception("Este paciente ya fue registrado");
        }

        // Validación de que solo el personal administrativo pueda crear el paciente
        if (user == null || !user.getRole().equals(Role.ADMINISTRATIVE_STAFF)) {
            throw new Exception("El paciente solo puede ser registrado por el personal administrativo");
        }

        patientPort.save(patient);
    }

    // Actualizar paciente
    public void updatePatient(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("Paciente no encontrado");
        }

        patientPort.update(patient);
    }

    // Consultar paciente
    public Patient getByDocument(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("Paciente no encontrado");
        }

        return patient;
    }
}
