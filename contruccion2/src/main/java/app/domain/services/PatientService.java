package app.domain.services;

import app.domain.model.Patient;
import app.domain.port.PatientPort;


public class PatientService {
	
	private PatientPort patientport;
	
	//Crear un paciente
	public void createPacient(Patient patient) throws Exception{
		
		//Validacion de que sea unico el paciente
		if(patientport.findByDocument(patient) != null) {
			throw new Exception("Este paciente ya fue registrado");
		}
		
		patientport.save(patient);
	}
}
