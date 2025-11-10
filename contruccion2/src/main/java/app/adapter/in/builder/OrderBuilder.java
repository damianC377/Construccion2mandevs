package app.adapter.in.builder;

import app.adapter.in.validators.OrderValidator;
import app.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBuilder {

    @Autowired
    private OrderValidator orderValidator;

    public <T extends Order> T build(
            T order,
            String orderNumber,
            String itemNumber,
            String cost
    ) throws Exception {

        order.setOrderNumber(orderValidator.orderNumberValidator(orderNumber));
        order.setItemNumber(orderValidator.itemNumberValidator(itemNumber));
        order.setCost(orderValidator.costValidator(cost));

        return order;
    }
}
