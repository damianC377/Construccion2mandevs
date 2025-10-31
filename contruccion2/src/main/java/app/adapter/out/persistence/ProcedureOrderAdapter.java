package app.adapter.out.persistence;

import app.domain.model.ProcedureOrder;
import app.domain.port.ProcedureOrderPort;
import app.infrastructure.persistence.entities.ProcedureOrderEntity;
import app.infrastructure.persistence.mapper.ProcedureOrderMapper;
import app.infrastructure.persistence.repository.ProcedureOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureOrderAdapter implements ProcedureOrderPort {

    @Autowired
    private ProcedureOrderRepository procedureOrderRepository;

    @Override
    public ProcedureOrder findByOrderNumber(long orderNumber) {
        ProcedureOrderEntity entity = procedureOrderRepository.findByOrderNumber(orderNumber);
        return ProcedureOrderMapper.toDomain(entity);
    }

    @Override
    public void save(ProcedureOrder order) {
        procedureOrderRepository.save(ProcedureOrderMapper.toEntity(order));
    }
}
