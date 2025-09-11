package app.domain.port;

import app.domain.model.HealthInsurance;

public interface HealthInsurancePort {
    // Guardar seguro de salud
    void save(HealthInsurance insurance) throws Exception;

}

