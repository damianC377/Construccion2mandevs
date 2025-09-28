package app.adapter.in.builder;

import app.adapter.in.validators.MedicalOrderValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class MedicalOrderBuilder {

    private PatientValidator patientValidator;
    private UserValidator userValidator;
    private MedicalOrderValidator medicalOrderValidator;


    public MedicalOrder build(String patientDocument, String doctorDocument,
                              String orderNumber, String orderDate, List<Order> items) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        User doctor = new User();
        MedicalOrder medicalOrder = new MedicalOrder();

        // Validar y asignar los atributos del MedicalOrder
        patient.setDocument(patientValidator.documentValidator(patientDocument));
        doctor.setDocument(userValidator.documentValidator(doctorDocument));
        medicalOrder.setPatient(patient);
        medicalOrder.setDoctor(doctor);
        medicalOrder.setOrderNumber(medicalOrderValidator.orderNumberValidator(orderNumber));
        medicalOrder.setOrderDate(medicalOrderValidator.orderDateValidator(orderDate));

        // Inicializar lista de ítems si es null
        if (items == null) {
            items = new ArrayList<>();
        }
        medicalOrder.setItems(items);

        return medicalOrder;
    }

    // Metodo para agregar item a la orden
    public void addItem(MedicalOrder medicalOrder, Order item) {
        if (medicalOrder.getItems() == null) {
            medicalOrder.setItems(new ArrayList<>());
        }
        medicalOrder.getItems().add(item);
    }
}

