package app.domain.services;

import app.domain.model.Patient;
import app.domain.port.PatientPort;

public class PatientService {


    private PatientPort patientPort;

    // Crear paciente
    public void create(Patient patient) throws Exception {
        // Validar que no exista un paciente con el mismo documento
        Patient foundPatient = patientPort.findByDocument(patient);
        if (foundPatient != null) {
            throw new Exception("Este paciente ya fue registrado");
        }

        patientPort.save(patient);
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
