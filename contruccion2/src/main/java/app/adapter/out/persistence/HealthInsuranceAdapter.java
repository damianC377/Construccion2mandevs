package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.HealthInsurance;
import app.domain.port.HealthInsurancePort;
import app.infrastructure.persistence.entities.HealthInsuranceEntity;
import app.infrastructure.persistence.mapper.HealthInsuranceMapper;
import app.infrastructure.persistence.repository.HealthInsuranceRepository;

@Service
public class HealthInsuranceAdapter implements HealthInsurancePort {

    @Autowired
    private HealthInsuranceRepository healthInsuranceRepository;

    @Override
    public void save(HealthInsurance insurance) throws Exception {
        // Conversión de dominio a entidad
        HealthInsuranceEntity entity = HealthInsuranceMapper.toEntity(insurance);
        // Guardar el seguro en la base de datos
        healthInsuranceRepository.save(entity);
    }

    @Override
    public HealthInsurance findById(long id) throws Exception {
        // Buscar por ID
        HealthInsuranceEntity entity = healthInsuranceRepository.findById(id).orElse(null);
        // Conversión de entidad a dominio
        return HealthInsuranceMapper.toDomain(entity);
    }

    @Override
    public HealthInsurance findByPolicyNumber(String policyNumber) throws Exception {
        // Buscar por número de póliza
        HealthInsuranceEntity entity = healthInsuranceRepository.findByPolicyNumber(policyNumber);
        // Conversión de entidad a dominio
        return HealthInsuranceMapper.toDomain(entity);
    }
}
