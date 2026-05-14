package app.infrastructure.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.entities.PatientEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    // Buscar facturas por paciente
    List<InvoiceEntity> findByPatient(PatientEntity patient);
}
