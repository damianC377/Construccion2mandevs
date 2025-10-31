package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import app.adapter.rest.request.*;
import app.adapter.rest.response.*;
import app.domain.model.*;
import java.util.Objects;

@Component
public class OrderRestMapper {

    /**
     * Convierte un objeto Request (del cliente) a una suborden del dominio.
     * Se detecta el tipo de orden según los campos que lleguen en el request.
     */
    public Order toDomain(OrderRequest req) {
        if (req == null) return null;

        // Si contiene información de medicamento → es una MedicationOrder
        if (req instanceof MedicationOrderRequest medicationReq) {
            MedicationOrder medicationOrder = new MedicationOrder();
            medicationOrder.setDosage(medicationReq.getDosage());
            medicationOrder.setTreatmentDuration(medicationReq.getTreatmentDuration());
            medicationOrder.setItemNumber(medicationReq.getItemNumber());
            medicationOrder.setCost(medicationReq.getCost());

            MedicationInventory medication =  new MedicationInventory();
            medication.setId(medicationReq.getMedicationId());
            medicationOrder.setMedication(medication);
            return medicationOrder;
        }

        // Si contiene información de procedimiento → es una ProcedureOrder
        if (req instanceof ProcedureOrderRequest procedureReq) {
            ProcedureOrder procedureOrder = new ProcedureOrder();
            procedureOrder.setQuantity(procedureReq.getQuantity());
            procedureOrder.setFrequency(procedureReq.getFrequency());
            procedureOrder.setRequiresSpecialist(procedureReq.isRequiresSpecialist());
            procedureOrder.setSpecialist(procedureReq.getSpecialist());
            procedureOrder.setItemNumber(procedureReq.getItemNumber());
            procedureOrder.setCost(procedureReq.getCost());

            ProcedureInventory procedure = new ProcedureInventory();
            procedure.setId(procedureReq.getProcedureId()); // solo ID
            procedureOrder.setProcedure(procedure);

            return procedureOrder;
        }

        // Si contiene información de prueba diagnóstica → DiagnosticTestOrder
        if (req instanceof DiagnosticTestOrderRequest diagnosticReq) {
            DiagnosticTestOrder diagnosticOrder = new DiagnosticTestOrder();
            diagnosticOrder.setQuantity(diagnosticReq.getQuantity());
            diagnosticOrder.setRequiresSpecialist(diagnosticReq.isRequiresSpecialist());
            diagnosticOrder.setSpecialist(diagnosticReq.getSpecialist());
            diagnosticOrder.setItemNumber(diagnosticReq.getItemNumber());
            diagnosticOrder.setCost(diagnosticReq.getCost());

            DiagnosticTestInventory diagnostic = new DiagnosticTestInventory();
            diagnostic.setId(diagnosticReq.getDiagnosticTestInventoryId());
            diagnosticOrder.setDiagnosticTestInventory(diagnostic);
            return diagnosticOrder;
        }

        // Si no coincide con ninguno, retorna null o lanza excepción
        return null;
    }

    /**
     * Convierte una suborden del dominio a un objeto Response (para enviar al cliente).
     */
    public OrderResponse toResponse(Order order) {
        if (order == null) return null;

        // 🔹 Medicamento
        if (order instanceof MedicationOrder medicationOrder) {
            MedicationOrderResponse res = new MedicationOrderResponse();
            res.setMedicationId(medicationOrder.getMedication().getId());
            res.setMedicationName(medicationOrder.getMedication().getName());
            res.setDosage(medicationOrder.getDosage());
            res.setTreatmentDuration(medicationOrder.getTreatmentDuration());
            res.setItemNumber(medicationOrder.getItemNumber());
            res.setCost(medicationOrder.getCost());
            return res;
        }

        // 🔹 Procedimiento
        if (order instanceof ProcedureOrder procedureOrder) {
            ProcedureOrderResponse res = new ProcedureOrderResponse();
            res.setProcedureId(procedureOrder.getProcedure().getId());
            res.setProcedureName(procedureOrder.getProcedure().getName());
            res.setQuantity(procedureOrder.getQuantity());
            res.setFrequency(procedureOrder.getFrequency());
            res.setRequiresSpecialist(procedureOrder.isRequiresSpecialist());
            res.setSpecialist(procedureOrder.getSpecialist());
            res.setItemNumber(procedureOrder.getItemNumber());
            res.setCost(procedureOrder.getCost());
            return res;
        }

        // 🔹 Prueba diagnóstica
        if (order instanceof DiagnosticTestOrder diagnosticOrder) {
            DiagnosticTestOrderResponse res = new DiagnosticTestOrderResponse();
            res.setDiagnosticTestInventoryId(diagnosticOrder.getDiagnosticTestInventory().getId());
            res.setDiagnosticTestName(diagnosticOrder.getDiagnosticTestInventory().getName());
            res.setQuantity(diagnosticOrder.getQuantity());
            res.setRequiresSpecialist(diagnosticOrder.isRequiresSpecialist());
            res.setSpecialist(diagnosticOrder.getSpecialist());
            res.setItemNumber(diagnosticOrder.getItemNumber());
            res.setCost(diagnosticOrder.getCost());
            return res;
        }

        return null;
    }
}
