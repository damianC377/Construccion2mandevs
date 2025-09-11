package app.domain.port;

import app.domain.model.Patient;

public interface PatientPort {

	// Encontrar paciente por documento
	public Patient findByDocument(Patient patient) throws Exception;
	
	// Guardar paciente
	public void save(Patient patient) throws Exception;

    // Actualizar paciente
    public void update(Patient patient) throws Exception;
    }



