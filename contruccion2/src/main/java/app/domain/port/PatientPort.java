package app.domain.port;

import app.domain.model.Patient;

public interface PatientPort {

	//Encuentra el documento del paciente
	public Patient findByDocument(Patient patient) throws Exception;
	
	//Guardar un paciente
	public void save(Patient patient) throws Exception;
}
