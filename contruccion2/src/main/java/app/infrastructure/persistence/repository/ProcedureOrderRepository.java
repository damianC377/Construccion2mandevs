package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.ProcedureInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.ProcedureOrderEntity;

@Repository
public interface ProcedureOrderRepository extends JpaRepository<ProcedureOrderEntity, Long> {
    // Buscar orden de procedimiento por su número
    ProcedureOrderEntity findByOrderNumber(long orderNumber);

}
