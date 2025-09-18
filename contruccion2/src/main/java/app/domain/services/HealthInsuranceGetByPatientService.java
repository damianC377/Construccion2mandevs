package app.domain.services;

import app.domain.model.HealthInsurance;
import app.domain.model.Patient;
import app.domain.port.PatientPort;

public class HealthInsuranceGetByPatientService {
	
	private PatientPort patientPort;
	
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
