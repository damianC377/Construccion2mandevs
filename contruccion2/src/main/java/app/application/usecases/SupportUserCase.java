package app.application.usecases;

import app.domain.model.MedicationInventory;
import app.domain.model.ProcedureInventory;
import app.domain.model.DiagnosticTestInventory;
import app.domain.services.*;

public class SupportUserCase {

    private CreateMedicationInventory addMedicationInventory;
    private SearchMedicationInventoryById searchMedicationInventoryById;

    private CreateProcedureInventory addProcedureInventory;
    private SearchProcedureInventoryById searchProcedureInventoryById;

    private CreateDiagnosticTestInventory addDiagnosticTestInventory;
    private SearchDiagnosticTestInventoryById searchDiagnosticTestInventoryById;


    // Crear y buscar medicamento en inventario
    public void createMedication(MedicationInventory medication) throws Exception {
        addMedicationInventory.create(medication);
    }
    public MedicationInventory searchMedication(MedicationInventory medication) throws Exception {
        return searchMedicationInventoryById.search(medication);
    }


    // Crear y buscar procedimiento en inventario
    public void createProcedure(ProcedureInventory procedure) throws Exception {
        addProcedureInventory.create(procedure);
    }
    public ProcedureInventory searchProcedure(ProcedureInventory procedure) throws Exception {
        return searchProcedureInventoryById.search(procedure);
    }


    // Crear y buscar test diagnóstico en inventario
    public void createDiagnosticTest(DiagnosticTestInventory diagnosticTest) throws Exception {
        addDiagnosticTestInventory.create(diagnosticTest);
    }
    public DiagnosticTestInventory searchDiagnosticTest(DiagnosticTestInventory diagnosticTest) throws Exception {
        return searchDiagnosticTestInventoryById.search(diagnosticTest);
    }
}
