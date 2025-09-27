package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticTestInventoryValidator;
import app.domain.model.DiagnosticTestInventory;

public class DiagnosticTestInventoryBuilder {

    private DiagnosticTestInventoryValidator diagnosticTestInventoryValidator;

    public DiagnosticTestInventory build(String name, String cost) throws Exception {

        DiagnosticTestInventory test = new DiagnosticTestInventory();
        test.setName(diagnosticTestInventoryValidator.nameValidator(name));
        test.setCost(diagnosticTestInventoryValidator.costValidator(cost));

        return test;
    }
}
