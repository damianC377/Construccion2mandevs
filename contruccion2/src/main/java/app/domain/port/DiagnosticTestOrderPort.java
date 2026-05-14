package app.domain.port;

import app.domain.model.DiagnosticTestOrder;

public interface DiagnosticTestOrderPort {

    // Buscar una orden de prueba diagnóstica por su número
    DiagnosticTestOrder findByOrderNumber(long orderNumber);

    // Guardar una orden de prueba diagnóstica
    void save(DiagnosticTestOrder order);
}
