package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.DiagnosticTestInventoryEntity;

@Repository
public interface DiagnosticTestInventoryRepository extends JpaRepository<DiagnosticTestInventoryEntity, Long> {
    // Buscar ayuda diagnóstica por id
    DiagnosticTestInventoryEntity findById(long id);
}
