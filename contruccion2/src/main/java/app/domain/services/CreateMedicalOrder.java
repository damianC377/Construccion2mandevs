package app.domain.services;

import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.MedicalOrderPort;
import app.domain.port.PatientPort;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicalOrder {

    @Autowired
    private MedicalOrderPort medicalOrderPort;
    @Autowired
    private PatientPort patientPort;
    @Autowired
    private UserPort userPort;
    @Autowired
    private UserRequireRole userRequireRole;
    @Autowired
    private ValidateOrdersRules validateOrdersRules;

    public void create(MedicalOrder order) throws Exception {
        // Validar si el paciente existe
        Patient patient = patientPort.findByDocument(order.getPatient());
        if (patient == null) {
            throw new Exception("El paciente no existe.");
        }

        //  Validar que el registro lo haga un doctor
        User doctor = userPort.findByDocument(order.getDoctor());
        userRequireRole.requireRole(Role.DOCTOR);

        // Asignar entidades validadas
        order.setPatient(patient);
        order.setDoctor(doctor);

        // Buscar si ya existe una orden con el mismo número
        MedicalOrder existingOrder = medicalOrderPort.findByOrderNumber(order.getOrderNumber());

        // Validar reglas de negocio del dominio
        validateOrdersRules.validate(order, existingOrder);

        medicalOrderPort.save(order);
    }
}

