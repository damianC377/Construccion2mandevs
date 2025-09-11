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
    public void create(Patient patient) throws Exception {
        // Validar que no exista un paciente con el mismo documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient != null) {
            throw new Exception("Este paciente ya fue registrado");
        }

        // Validar que el registro lo haga personal administrativo
        User administrativeStaff = userPort.findByDocument(patient.getAdministrativeStaff());
        if (administrativeStaff == null || administrativeStaff.getRole() != Role.ADMINISTRATIVE_STAFF) {
            throw new Exception("El paciente solo puede ser registrado por personal administrativo");
        }

        patientPort.save(patient);
    }

    // Actualizar paciente
    public void update(Patient patient) throws Exception {
        // Validar que el paciente exista
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient == null) {
            throw new Exception("Paciente no encontrado");
        }

        patientPort.update(patient);
    }

    // Consultar paciente
    public Patient getByDocument(Patient patient) throws Exception {
        // Buscar paciente por documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient == null) {
            throw new Exception("Paciente no encontrado");
        }

        return foundPatient;
    }
}
