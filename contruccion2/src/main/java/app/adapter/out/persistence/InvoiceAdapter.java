package app.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.port.InvoicePort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;

@Service
public class InvoiceAdapter implements InvoicePort {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void create(Invoice invoice) throws Exception {
        // Conversión de dominio a entidad
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        // Guardar factura generada
        invoiceRepository.save(entity);
    }

    @Override
    public void save(Invoice invoice) throws Exception {
        // Conversión de dominio a entidad
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        // Guardar factura en base de datos
        invoiceRepository.save(entity);
    }

    @Override
    public List<Invoice> findByPatient(Patient patient) {
        // Buscar facturas por paciente
        List<InvoiceEntity> entities = invoiceRepository.findByPatient(PatientMapper.toEntity(patient));
        // Convertir entidades a dominio
        List<Invoice> invoices = new ArrayList<>();
        for (InvoiceEntity entity : entities) {
            invoices.add(InvoiceMapper.toDomain(entity));
        }
        return invoices;
    }
}
