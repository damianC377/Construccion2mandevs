package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.ProcedureInventoryEntity;

@Repository
public interface ProcedureInventoryRepository extends JpaRepository<ProcedureInventoryEntity, Long> {
    // Buscar procedimiento por id
    ProcedureInventoryEntity findById(long id);
}
