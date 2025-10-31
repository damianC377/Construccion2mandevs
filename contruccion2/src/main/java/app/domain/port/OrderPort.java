package app.domain.port;

import app.domain.model.Order;

public interface OrderPort {

    // Buscar una orden por su número
    Order findByOrderNumber(long orderNumber) throws Exception;

    // Guardar una nueva orden
    void save(Order order) throws Exception;
}
