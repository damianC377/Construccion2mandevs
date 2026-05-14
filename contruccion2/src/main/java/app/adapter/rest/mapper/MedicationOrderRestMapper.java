package app.adapter.rest.mapper;

import app.adapter.in.builder.MedicationOrderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.domain.model.MedicationInventory;
import app.domain.model.MedicationOrder;
import app.adapter.rest.request.MedicationOrderRequest;
import app.adapter.rest.response.MedicationOrderResponse;

@Component
public class MedicationOrderRestMapper {

    @Autowired
    private MedicationOrderBuilder medicationOrderBuilder;

    public MedicationOrder toDomain(MedicationOrderRequest req) throws Exception {
        return medicationOrderBuilder.build(
                req.getOrderNumber(),
                req.getItemNumber(),
                req.getCost(),
                req.getMedicationInventoryId(),
                req.getDosage(),
                req.getTreatmentDuration()
                );
    }

    public MedicationOrderResponse toResponse(MedicationOrder order) {
        MedicationOrderResponse res = new MedicationOrderResponse();
        res.setItemNumber(order.getItemNumber());
        res.setCost(order.getCost());
        res.setDosage(order.getDosage());
        res.setTreatmentDuration(order.getTreatmentDuration());


        if (order.getMedication() != null) {
            MedicationInventory medicationInventory = order.getMedication();
            res.setMedicationId(medicationInventory.getId());
            res.setMedicationName(medicationInventory.getName());
        }

        return res;
    }
}
