package app.domain.port;

import app.domain.model.DiagnosticTestInventory;

public interface DiagnosticTestInventoryPort {

    // Encontrar la ayuda diagnóstica por id
    public DiagnosticTestInventory findById(DiagnosticTestInventory diagnosticTest) throws Exception;

    // Guardar la ayuda diagnóstica
    public void save(DiagnosticTestInventory diagnosticTest);
}
