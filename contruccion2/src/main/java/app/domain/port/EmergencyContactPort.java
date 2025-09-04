package app.domain.port;

import app.domain.model.EmergencyContact;

public interface EmergencyContactPort {
    // Crear contacto de emergencia
    void save(EmergencyContact contact) throws Exception;

    // Actualizar contacto de emergencia
    void update(EmergencyContact contact) throws Exception;
}

