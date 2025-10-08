package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticTestInventoryValidator;
import app.domain.model.DiagnosticTestInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DiagnosticTestInventoryBuilder {

    @Autowired
    private DiagnosticTestInventoryValidator diagnosticTestInventoryValidator;

    public DiagnosticTestInventory build(String name, String cost) throws Exception {

        DiagnosticTestInventory test = new DiagnosticTestInventory();
        test.setName(diagnosticTestInventoryValidator.nameValidator(name));
        test.setCost(diagnosticTestInventoryValidator.costValidator(cost));

        return test;
    }
}
