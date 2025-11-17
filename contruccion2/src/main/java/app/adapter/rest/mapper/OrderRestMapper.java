package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import app.adapter.rest.request.*;
import app.adapter.rest.response.*;
import app.domain.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import app.adapter.in.builder.MedicationOrderBuilder;
import app.adapter.in.builder.ProcedureOrderBuilder;
import app.adapter.in.builder.DiagnosticTestOrderBuilder;

@Component
public class OrderRestMapper {

    @Autowired
    private MedicationOrderBuilder medicationOrderBuilder;

    @Autowired
    private ProcedureOrderBuilder procedureOrderBuilder;

    @Autowired
    private DiagnosticTestOrderBuilder diagnosticTestOrderBuilder;

    /**
     * Convierte un objeto Request (del cliente) a una suborden del dominio.
     * Se detecta el tipo de orden según los campos que lleguen en el request.
     */
    public Order toDomain(OrderRequest req) {
        if (req == null) return null;

        // Si contiene información de medicamento → es una MedicationOrder
        if (req instanceof MedicationOrderRequest medicationReq) {
            try {
                return medicationOrderBuilder.build(
                        medicationReq.getOrderNumber(),
                        medicationReq.getItemNumber(),
                        medicationReq.getCost(),
                        medicationReq.getMedicationInventoryId(),
                        medicationReq.getDosage(),
                        medicationReq.getTreatmentDuration()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Si contiene información de procedimiento → es una ProcedureOrder
        if (req instanceof ProcedureOrderRequest procedureReq) {
            try {
                return procedureOrderBuilder.build(
                        procedureReq.getOrderNumber(),
                        procedureReq.getItemNumber(),
                        procedureReq.getCost(),
                        procedureReq.getProcedureId(),
                        procedureReq.getQuantity(),
                        procedureReq.getFrequency(),
                        procedureReq.getRequiresSpecialist(),
                        procedureReq.getSpecialist()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Si contiene información de prueba diagnóstica → DiagnosticTestOrder
        if (req instanceof DiagnosticTestOrderRequest diagnosticReq) {
            try {
                return diagnosticTestOrderBuilder.build(
                        diagnosticReq.getOrderNumber(),
                        diagnosticReq.getItemNumber(),
                        diagnosticReq.getCost(),
                        diagnosticReq.getDiagnosticTestInventoryId(),
                        diagnosticReq.getQuantity(),
                        diagnosticReq.getRequiresSpecialist(),
                        diagnosticReq.getSpecialist()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
