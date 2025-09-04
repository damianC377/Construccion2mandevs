package app.domain.port;

import app.domain.model.HealthInsurance;

public interface HealthInsurancePort {
    // Crear seguro de salud
    void save(HealthInsurance insurance) throws Exception;

    // Actualizar seguro de salud
    void update(HealthInsurance insurance) throws Exception;
}

