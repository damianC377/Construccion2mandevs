package app.domain.port;

import app.domain.model.ProcedureOrder;

public interface ProcedureOrderPort {

    // Buscar una orden de procedimiento por su número
    ProcedureOrder findByOrderNumber(long orderNumber);

    // Guardar una orden de procedimiento
    void save(ProcedureOrder order);
}
