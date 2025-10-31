package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.MedicalOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicalOrderRepository extends JpaRepository<MedicalOrderEntity, Long> {

    // Buscar orden médica por el número único de orden
    MedicalOrderEntity findByOrderNumber(long orderNumber);

    // Buscar todas las órdenes asociadas a un paciente específico
    List<MedicalOrderEntity> findByPatientId(Long patientId);
}
