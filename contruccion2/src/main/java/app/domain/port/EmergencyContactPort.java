package app.domain.port;

import app.domain.model.EmergencyContact;

public interface EmergencyContactPort {
    // Guardar contacto de emergencia
    void save(EmergencyContact contact) throws Exception;

}

