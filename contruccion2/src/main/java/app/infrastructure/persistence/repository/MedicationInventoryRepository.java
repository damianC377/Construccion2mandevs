package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.MedicationInventoryEntity;

@Repository
public interface MedicationInventoryRepository extends JpaRepository<MedicationInventoryEntity, Long> {
    // Buscar medicamento por id
    MedicationInventoryEntity findById(long id);
}
