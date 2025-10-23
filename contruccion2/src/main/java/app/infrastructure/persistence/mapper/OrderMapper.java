package app.infrastructure.persistence.mapper;

import app.domain.model.Order;
import app.infrastructure.persistence.entities.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(Order order){
        if (order == null) return null;
        OrderEntity Entity = new OrderEntity();
        Entity.setItemNumber(order.getItemNumber());
    }
}
