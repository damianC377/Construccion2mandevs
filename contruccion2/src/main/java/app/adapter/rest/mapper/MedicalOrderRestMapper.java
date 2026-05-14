package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.rest.request.MedicalOrderRequest;
import app.adapter.rest.response.MedicalOrderResponse;
import app.domain.model.MedicalOrder;
import app.domain.model.Order;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Collections;

import app.adapter.in.builder.MedicalOrderBuilder;

@Component
public class MedicalOrderRestMapper {

    @Autowired
    private OrderRestMapper orderRestMapper; // 🔹 Mapea los diferentes tipos de subórdenes

    @Autowired
    private MedicalOrderBuilder medicalOrderBuilder;

    /**
     * Convierte un objeto Request (del cliente) a un objeto del dominio.
     */
    public MedicalOrder toDomain(MedicalOrderRequest req) throws Exception {
        if (req == null) return null;

        List<Order> rawItems = (req.getItems() != null && !req.getItems().isEmpty())
                ? req.getItems().stream().map(orderRestMapper::toDomain).collect(Collectors.toList())
                : Collections.emptyList();

        return medicalOrderBuilder.build(
                req.getPatientDocument(),
                req.getDoctorDocument(),
                req.getOrderDate(),
                req.getOrderNumber(),
                rawItems
        );
    }

    /**
     * Convierte un objeto del dominio a un objeto Response (para enviar al cliente).
     */
    public MedicalOrderResponse toResponse(MedicalOrder domain) {
        if (domain == null) return null;

        MedicalOrderResponse res = new MedicalOrderResponse();
        res.setOrderNumber(domain.getOrderNumber());
        res.setOrderDate(domain.getOrderDate());
        res.setPatientName(domain.getPatient() != null ? domain.getPatient().getFullName() : null);
        res.setDoctorName(domain.getDoctor() != null ? domain.getDoctor().getUserName() : null);

        // 🔹 Convierte los ítems a response usando el OrderRestMapper
        if (domain.getItems() != null && !domain.getItems().isEmpty()) {
            res.setItemsSummary(domain.getItems().stream()
                    .map(o -> {
                        var r = orderRestMapper.toResponse(o);
                        // resumen simple: tipo + itemNumber
                        return r.getClass().getSimpleName() + "#" + r.getItemNumber();
                    })
                    .collect(Collectors.toList()));
        }

        return res;
    }
}
