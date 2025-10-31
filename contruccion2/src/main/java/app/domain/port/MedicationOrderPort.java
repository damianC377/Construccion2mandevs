package app.domain.port;

import app.domain.model.MedicationOrder;

public interface MedicationOrderPort {

    // Buscar una orden de medicamento por su número
    MedicationOrder findByOrderNumber(long orderNumber);

    // Guardar una orden de medicamento
    void save(MedicationOrder order);
}
