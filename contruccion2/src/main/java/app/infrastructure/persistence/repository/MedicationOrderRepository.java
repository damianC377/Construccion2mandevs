package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.MedicationOrderEntity;

@Repository
public interface MedicationOrderRepository extends JpaRepository<MedicationOrderEntity, Long> {
    // Buscar orden de medicamento por su número
    MedicationOrderEntity findByOrderNumber(long orderNumber);
}
