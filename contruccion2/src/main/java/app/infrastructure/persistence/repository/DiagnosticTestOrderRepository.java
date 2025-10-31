package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entities.DiagnosticTestOrderEntity;

@Repository
public interface DiagnosticTestOrderRepository extends JpaRepository<DiagnosticTestOrderEntity, Long> {
    // Buscar orden de prueba diagnóstica por su número
    DiagnosticTestOrderEntity findByOrderNumber(long orderNumber);
}
