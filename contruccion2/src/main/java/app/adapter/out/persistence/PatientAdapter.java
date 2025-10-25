package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.port.PatientPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientRepository;

@Service
public class PatientAdapter implements PatientPort {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) throws Exception {
        // Conversión de dominio a entidad
        PatientEntity entity = PatientMapper.toEntity(patient);
        // Guardar el paciente en la base de datos
        patientRepository.save(entity);
    }

    @Override
    public Patient findByDocument(Patient patient) throws Exception {
        // Buscar por documento
        PatientEntity entity = patientRepository.findByDocument(patient.getDocument());
        // Conversión de entidad a dominio
        return PatientMapper.toDomain(entity);
    }
}

