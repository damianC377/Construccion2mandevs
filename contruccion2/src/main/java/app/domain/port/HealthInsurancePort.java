package app.domain.port;

import app.domain.model.HealthInsurance;

public interface HealthInsurancePort {
	
	//Buscar por Id
	public HealthInsurance findById(long id) throws Exception;
	
    // Guardar seguro de salud
    void save(HealthInsurance insurance) throws Exception;

}

