package app.adapter.out.persistence;

import app.domain.model.Order;
import app.domain.port.OrderPort;
import app.infrastructure.persistence.entities.OrderEntity;
import app.infrastructure.persistence.mapper.OrderMapper;
import app.infrastructure.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderAdapter implements OrderPort {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findByOrderNumber(long orderNumber) throws Exception {
        OrderEntity orderEntity = orderRepository.findByOrderNumber(orderNumber);
        if (orderEntity == null) {
            throw new Exception("No se encontró una orden con el número: " + orderNumber);
        }
        return OrderMapper.toDomain(orderEntity);
    }

    @Override
    public void save(Order order) throws Exception {
        orderRepository.save(OrderMapper.toEntity(order));
    }
}
