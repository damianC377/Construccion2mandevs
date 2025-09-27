package app.adapter.in.builder;

import app.adapter.in.validators.ProcedureInventoryValidator;
import app.domain.model.ProcedureInventory;

public class ProcedureInventoryBuilder {

    private ProcedureInventoryValidator procedureInventoryValidator;

    public ProcedureInventory build(String name, String cost) throws Exception {

        ProcedureInventory procedure = new ProcedureInventory();
        procedure.setName(procedureInventoryValidator.nameValidator(name));
        procedure.setCost(procedureInventoryValidator.costValidator(cost));

        return procedure;
    }
}
