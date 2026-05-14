package app.adapter.out.persistence;

import app.domain.model.DiagnosticTestOrder;
import app.domain.port.DiagnosticTestOrderPort;
import app.infrastructure.persistence.entities.DiagnosticTestOrderEntity;
import app.infrastructure.persistence.mapper.DiagnosticTestOrderMapper;
import app.infrastructure.persistence.repository.DiagnosticTestOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticTestOrderAdapter implements DiagnosticTestOrderPort {

    @Autowired
    private DiagnosticTestOrderRepository diagnosticTestOrderRepository;

    @Override
    public DiagnosticTestOrder findByOrderNumber(long orderNumber) {
        DiagnosticTestOrderEntity entity = diagnosticTestOrderRepository.findByOrderNumber(orderNumber);
        return DiagnosticTestOrderMapper.toDomain(entity);
    }

    @Override
    public void save(DiagnosticTestOrder order) {
        diagnosticTestOrderRepository.save(DiagnosticTestOrderMapper.toEntity(order));
    }
}
