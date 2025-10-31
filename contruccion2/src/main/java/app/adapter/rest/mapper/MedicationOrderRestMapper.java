package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.domain.model.MedicationInventory;
import app.domain.model.MedicationOrder;
import app.adapter.rest.request.MedicationOrderRequest;
import app.adapter.rest.response.MedicationOrderResponse;

@Component
public class MedicationOrderRestMapper {

    public MedicationOrder toDomain(MedicationOrderRequest req) {
        MedicationOrder order = new MedicationOrder();
        order.setItemNumber(req.getItemNumber());
        order.setCost(req.getCost());
        order.setDosage(req.getDosage());
        order.setTreatmentDuration(req.getTreatmentDuration());

        MedicationInventory medication = new MedicationInventory();
        medication.setId(req.getMedicationId());
        order.setMedication(medication);

        return order;
    }

    public MedicationOrderResponse toResponse(MedicationOrder order) {
        MedicationOrderResponse res = new MedicationOrderResponse();
        res.setItemNumber(order.getItemNumber());
        res.setCost(order.getCost());
        res.setDosage(order.getDosage());
        res.setTreatmentDuration(order.getTreatmentDuration());

        if (order.getMedication() != null) {
            res.setMedicationName(order.getMedication().getName());
        }

        return res;
    }
}
