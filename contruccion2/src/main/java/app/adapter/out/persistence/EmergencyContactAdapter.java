package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.port.EmergencyContactPort;
import app.infrastructure.persistence.entities.EmergencyContactEntity;
import app.infrastructure.persistence.mapper.EmergencyContactMapper;
import app.infrastructure.persistence.repository.EmergencyContactRepository;

@Service
public class EmergencyContactAdapter implements EmergencyContactPort {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Override
    public void save(EmergencyContact contact) throws Exception {
        // Conversión de dominio a entidad
        EmergencyContactEntity entity = EmergencyContactMapper.toEntity(contact);
        // Guardar el contacto de emergencia en la base de datos
        emergencyContactRepository.save(entity);
    }
}
