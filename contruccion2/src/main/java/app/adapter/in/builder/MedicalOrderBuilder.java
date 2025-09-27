package app.adapter.in.builder;

import java.sql.Date;
import java.util.List;

import app.adapter.in.validators.MedicalOrderValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.MedicalOrder;
import app.domain.model.Order;
import app.domain.model.Patient;
import app.domain.model.User;

public class MedicalOrderBuilder {

    private PatientValidator patientValidator;
    private UserValidator userValidator;
    private MedicalOrderValidator medicalOrderValidator;

    public MedicalOrder build(String patientDocument, String doctorDocument, String orderNumber,
                              String orderDate,  List<Order> items) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        User doctor = new User();
        MedicalOrder medicalOrder = new MedicalOrder();
        patient.setDocument(patientValidator.documentValidator(patientDocument));
        doctor.setDocument(userValidator.documentValidator(doctorDocument));
        medicalOrder.setPatient(patient);
        medicalOrder.setDoctor(doctor);

        // Validar y asignar los atributos del MedicalOrder
        medicalOrder.setOrderNumber(medicalOrderValidator.orderNumberValidator(orderNumber));
        medicalOrder.setOrderDate(medicalOrderValidator.orderDateValidator(orderDate));
        medicalOrder.setItems(items);

        return medicalOrder;
    }
}
