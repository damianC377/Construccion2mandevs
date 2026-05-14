package app.domain.services;

import app.domain.model.MedicationInventory;
import app.domain.model.enums.Role;
import app.domain.port.MedicationInventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import app.application.exceptions.BusinessException;

@Service
public class SearchMedicationInventoryById {
    @Autowired
    private MedicationInventoryPort medicationInventoryPort;

    // Buscar medicamento en inventario
    public MedicationInventory search(MedicationInventory medication) throws Exception {
        // Validar rol
        requireRole(Role.SUPPORT);

        // Validar que no este vacio
        if (medication == null || medication.getName() == null) {
            throw new Exception("El medicamento es obligatorio");
        }

        // Buscar en inventario
        MedicationInventory medicationFound = medicationInventoryPort.findById(medication);
        if (medicationFound == null) {
            throw new Exception("No se encontró el medicamento: " + medication.getName());
        }

        return medicationFound;
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
