package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.rest.request.MedicalOrderRequest;
import app.adapter.rest.response.MedicalOrderResponse;
import app.domain.model.MedicalOrder;
import app.domain.model.Order;

import java.util.stream.Collectors;

@Component
public class MedicalOrderRestMapper {

    @Autowired
    private OrderRestMapper orderRestMapper; // 🔹 Mapea los diferentes tipos de subórdenes

    /**
     * Convierte un objeto Request (del cliente) a un objeto del dominio.
     */
    public MedicalOrder toDomain(MedicalOrderRequest req) throws Exception {
        if (req == null) return null;

        MedicalOrder order = new MedicalOrder();
        order.setOrderNumber(req.getOrderNumber());
        order.setOrderDate(req.getOrderDate());
        order.setDoctor(req.getDoctor());
        order.setPatient(req.getPatient());

        // 🔹 Convierte los ítems (subórdenes) del request al dominio
        if (req.getItems() != null && !req.getItems().isEmpty()) {
            order.setItems(req.getItems().stream()
                    .map(orderRestMapper::toDomain)
                    .collect(Collectors.toList()));
        }

        return order;
    }

    /**
     * Convierte un objeto del dominio a un objeto Response (para enviar al cliente).
     */
    public MedicalOrderResponse toResponse(MedicalOrder domain) {
        if (domain == null) return null;

        MedicalOrderResponse res = new MedicalOrderResponse();
        res.setOrderNumber(domain.getOrderNumber());
        res.setOrderDate(domain.getOrderDate());
        res.setDoctor(domain.getDoctor());
        res.setPatient(domain.getPatient());

        // 🔹 Convierte los ítems a response usando el OrderRestMapper
        if (domain.getItems() != null && !domain.getItems().isEmpty()) {
            res.setItems(domain.getItems().stream()
                    .map(orderRestMapper::toResponse)
                    .collect(Collectors.toList()));
        }

        return res;
    }
}
