package app.adapter.in.builder;

import app.adapter.in.validators.*;
import app.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicalOrderBuilder {

    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private MedicalOrderValidator medicalOrderValidator;
    @Autowired
    private MedicationOrderValidator medicationOrderValidator;
    @Autowired
    private ProcedureOrderValidator procedureOrderValidator;
    @Autowired
    private DiagnosticTestOrderValidator diagnosticTestOrderValidator;

    public MedicalOrder build(String patientDocument, String doctorDocument, String orderDate,
                              String orderNumber, List<Order> rawItems) throws Exception {

        // Crear e inicializar los objetos principales de la orden
        Patient patient = new Patient();
        User doctor = new User();
        MedicalOrder medicalOrder = new MedicalOrder();

        // Validar y asignar los atributos generales de la orden médica
        patient.setDocument(patientValidator.documentValidator(patientDocument));
        doctor.setDocument(userValidator.documentValidator(doctorDocument));
        medicalOrder.setOrderNumber(medicalOrderValidator.orderNumberValidator(orderNumber));
        medicalOrder.setPatient(patient);
        medicalOrder.setDoctor(doctor);
        medicalOrder.setOrderDate(medicalOrderValidator.orderDateValidator(orderDate));

        // Lista donde se guardarán las órdenes validadas (medicamentos, procedimientos, diagnósticos)
        List<Order> validatedItems = new ArrayList<>();

        // Recorrer cada ítem recibido para validar y construir el tipo correcto
        for (Order item : rawItems) {

            // Caso 1: Orden de medicamento
            if (item instanceof MedicationOrder med) {
                MedicationOrder medicationOrder = new MedicationOrder();
                medicationOrder.setMedication(med.getMedication()); // viene de inventario, no se valida aquí
                medicationOrder.setDosage(medicationOrderValidator.dosageValidator(med.getDosage()));
                medicationOrder.setTreatmentDuration(medicationOrderValidator.treatmentDurationValidator(med.getTreatmentDuration()));
                medicationOrder.setItemNumber(med.getItemNumber());
                validatedItems.add(medicationOrder);
            }

            // Caso 2: Orden de procedimiento
            else if (item instanceof ProcedureOrder proc) {
                ProcedureOrder procedureOrder = new ProcedureOrder();
                procedureOrder.setProcedure(proc.getProcedure());
                procedureOrder.setQuantity(procedureOrderValidator.quantityValidator(String.valueOf(proc.getQuantity())));
                procedureOrder.setFrequency(procedureOrderValidator.frequencyValidator(proc.getFrequency()));
                procedureOrder.setRequiresSpecialist(procedureOrderValidator.requiresSpecialistValidator(proc.isRequiresSpecialist()));
                procedureOrder.setSpecialist(procedureOrderValidator.specialistValidator(proc.getSpecialist()));
                procedureOrder.setItemNumber(proc.getItemNumber());
                validatedItems.add(procedureOrder);
            }

            // Caso 3: Orden de ayuda diagnóstica
            else if (item instanceof DiagnosticTestOrder diag) {
                DiagnosticTestOrder diagnosticOrder = new DiagnosticTestOrder();
                diagnosticOrder.setDiagnosticTestInventory(diag.getDiagnosticTestInventory());
                diagnosticOrder.setQuantity(diagnosticTestOrderValidator.quantityValidator(String.valueOf(diag.getQuantity())));
                diagnosticOrder.setRequiresSpecialist(diagnosticTestOrderValidator.requiresSpecialistValidator(diag.isRequiresSpecialist()));
                diagnosticOrder.setSpecialist(diagnosticTestOrderValidator.specialistValidator(diag.getSpecialist()));
                diagnosticOrder.setItemNumber(diag.getItemNumber());
                validatedItems.add(diagnosticOrder);
            }

            else {
                throw new Exception("Tipo de ítem desconocido en la orden médica.");
            }
        }

        medicalOrder.setItems(validatedItems);

        return medicalOrder;
    }
}
