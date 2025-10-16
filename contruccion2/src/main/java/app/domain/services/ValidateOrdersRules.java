package app.domain.services;

import app.domain.model.*;
import app.domain.port.MedicalRecordPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidateOrdersRules {

    @Autowired
    private MedicalRecordPort medicalRecordPort;

    public void validate(MedicalOrder order, MedicalOrder existingOrder) throws Exception {

        List<Order> items = order.getItems();
        boolean hasMedication = false;
        boolean hasProcedure = false;
        boolean hasDiagnostic = false;

        // Identificar los tipos de ítems incluidos en la orden
        for (Order item : items) {
            if (item instanceof MedicationOrder) hasMedication = true;
            if (item instanceof ProcedureOrder) hasProcedure = true;
            if (item instanceof DiagnosticTestOrder) hasDiagnostic = true;
        }

        // Cuando se receta una ayuda diagnóstica no puede recetarse procedimiento ni medicamento
        if (hasDiagnostic && (hasMedication || hasProcedure)) {
            throw new Exception("No puede mezclarse ayuda diagnóstica con medicamentos o procedimientos.");
        }

        // Verifica que no exista un diagnóstico previo antes de registrar tratamientos asociados a la ayuda diagnóstica
        if (hasDiagnostic) {
            MedicalRecord record = medicalRecordPort.findByPatient(order.getPatient());
            if (record != null && record.getDiagnosis() != null && !record.getDiagnosis().isEmpty()) {
                throw new Exception("El paciente ya tiene diagnóstico registrado. Cree una nueva orden con tratamientos.");
            }
        }

        // Las órdenes deben ser únicas
        if (existingOrder != null) {
            throw new Exception("Ya existe una orden con ese número.");
        }

        //  No puede haber dos elementos dentro de la misma orden con el mismo ítem
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).getItemNumber() == items.get(j).getItemNumber()) {
                    throw new Exception("No pueden existir dos ítems con el mismo número dentro de la misma orden.");
                }
            }
        }
    }
}
