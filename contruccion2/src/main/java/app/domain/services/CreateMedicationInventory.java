package app.domain.services;

import app.application.exceptions.BusinessException;
import app.domain.model.MedicationInventory;
import app.domain.model.enums.Role;
import app.domain.port.MedicationInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class CreateMedicationInventory {
    @Autowired
    private MedicationInventoryPort medicationInventoryPort;

    public void create(MedicationInventory medication) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

        // Validar que no esté vacío
        if (medication == null || medication.getName() == null) {
            throw new Exception("El nombre del medicamento es obligatorio");
        }

        // Validar costo
        if (medication.getCost() <= 0) {
            throw new Exception("El costo debe ser mayor que cero");
        }

        // Validar duplicados
        MedicationInventory existing = medicationInventoryPort.findById(medication);
        if (existing != null) {
            throw new BusinessException("El medicamento ya está registrado en el inventario");
        }

        // Guardar en inventario
        medicationInventoryPort.save(medication);
    }

    private void requireRole(Role role) throws BusinessException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new BusinessException("Usuario no autenticado");
        }
        String needed = "ROLE_" + role.name();
        boolean ok = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(needed));
        if (!ok) throw new BusinessException("Acceso denegado");
    }

}
