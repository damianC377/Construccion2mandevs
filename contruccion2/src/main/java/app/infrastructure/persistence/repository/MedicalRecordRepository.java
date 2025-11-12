package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.MedicalRecordEntity;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordEntity, Long> {

    // Búsqueda simplificada por patientId
    MedicalRecordEntity findByPatientId(Long patientId);
}
