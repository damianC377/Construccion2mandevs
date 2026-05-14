package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.HealthInsuranceEntity;

@Repository
public interface HealthInsuranceRepository extends JpaRepository<HealthInsuranceEntity, Long> {
    // Buscar por número de póliza (tipo Long en la entidad)
    HealthInsuranceEntity findByPolicyNumber(Long policyNumber);
}
