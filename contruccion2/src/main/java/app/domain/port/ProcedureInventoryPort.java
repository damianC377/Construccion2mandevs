package app.domain.port;


import app.domain.model.ProcedureInventory;

public interface ProcedureInventoryPort {
    // Encontrar procedimiento por id
    public ProcedureInventory findById(ProcedureInventory procedure) throws Exception;

    // Guardar procedimiento
    public void save(ProcedureInventory procedure) throws Exception;
}
