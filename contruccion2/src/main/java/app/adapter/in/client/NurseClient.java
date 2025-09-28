package app.adapter.in.client;

import app.adapter.in.builder.MedicalOrderBuilder;
import app.application.usecases.NurseUserCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseClient {

    // Mostrar menú principal
    private static final String MENU = """
            Ingrese una opción:
             1. Registrar orden médica
             2. Buscar orden médica
             3. Registrar signos vitales
             4. Cerrar sesión""";

    private static Scanner sc = new Scanner(System.in);

    private NurseUserCase nurseUserCase;
    private MedicalOrderBuilder medicalOrderBuilder;
    private LoginUseCase loginUseCase;

    // Iniciar sesión y mantener el menú
    public void session() {
        while (loginUseCase.getUserCurrent() != null) { // Mientras haya usuario logueado
            menu(); // Mostrar menú
        }
    }

    // Menú principal
    private void menu() {
        System.out.println(MENU);
        String option = sc.nextLine();
        try {
            switch (option) {
                case "1":
                    registerMedicalOrder();
                    break;
                case "2":
                    System.out.println("Buscar orden medica");
                    break;
                case "3":
                    registerVitalSigns();
                    break;
                case "4":
                    System.out.println("Cerrando sesión...");
                    loginUseCase.logout();
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Registrar orden médica
    private void registerMedicalOrder() throws Exception {
        // Datos básicos
        System.out.println("Documento del paciente:");
        String patientDoc = sc.nextLine();
        System.out.println("Documento del doctor:");
        String doctorDoc = sc.nextLine();
        System.out.println("Número de orden:");
        String orderNumber = sc.nextLine();
        System.out.println("Fecha de la orden (yyyy-mm-dd):");
        String orderDate = sc.nextLine();

        // Lista de ítems de la orden
        List<Order> items = new ArrayList<>();
        boolean addMore = true;
        while (addMore) {
            System.out.println("Ingrese tipo de ítem:");
            System.out.println("1. Medicamento\n2. Procedimiento\n3. Test diagnóstico\n4. Terminar");
            String type = sc.nextLine();
            switch (type) {
                case "1": items.add(createMedicationOrder()); break;
                case "2": items.add(createProcedureOrder()); break;
                case "3": items.add(createDiagnosticTestOrder()); break;
                case "4": addMore = false; break; // Salir del menú de ítems
                default: System.out.println("Opción inválida");
            }
        }

        // Construir la orden médica usando el builder
        MedicalOrder order = medicalOrderBuilder.build(patientDoc, doctorDoc, orderNumber, orderDate, items);
        nurseUserCase.createMedicalOrder(order); // Guardar la orden
        System.out.println("Orden médica registrada correctamente.");
    }

    // Registrar signos vitales
    private void registerVitalSigns() {
        System.out.println("Registro de signos vitales del paciente:");
        System.out.println("Presión arterial:"); String pressure = sc.nextLine();
        System.out.println("Temperatura:"); String temperature = sc.nextLine();
        System.out.println("Pulso:"); String pulse = sc.nextLine();
        System.out.println("Nivel de oxígeno:"); String oxygen = sc.nextLine();

        System.out.println("Signos vitales registrados:");
        System.out.println("Presión: " + pressure + ", Temperatura: " + temperature +
                ", Pulso: " + pulse + ", Oxígeno: " + oxygen);
    }

    // Crear ítem tipo medicamento
    private Order createMedicationOrder() {
        MedicationOrder medicationOrder = new MedicationOrder();
        System.out.println("Dosis:"); medicationOrder.setDosage(sc.nextLine());
        System.out.println("Duración del tratamiento:"); medicationOrder.setTreatmentDuration(sc.nextLine());
        return medicationOrder;
    }

    // Crear ítem tipo procedimiento
    private Order createProcedureOrder() {
        ProcedureOrder procedureOrder = new ProcedureOrder();
        System.out.println("Frecuencia:"); procedureOrder.setFrequency(sc.nextLine());
        System.out.println("Requiere especialista? (sí/no):");
        procedureOrder.setRequiresSpecialist(sc.nextLine().equalsIgnoreCase("sí"));
        return procedureOrder;
    }

    // Crear ítem tipo test diagnóstico
    private Order createDiagnosticTestOrder() {
        DiagnosticTestOrder diagnosticTestOrder = new DiagnosticTestOrder();
        System.out.println("Cantidad:"); diagnosticTestOrder.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.println("Requiere especialista? (sí/no):");
        diagnosticTestOrder.setRequiresSpecialist(sc.nextLine().equalsIgnoreCase("sí"));
        if (diagnosticTestOrder.isRequiresSpecialist()) {
            System.out.println("Especialista requerido:"); diagnosticTestOrder.setSpecialist(sc.nextLine());
        }
        return diagnosticTestOrder;
    }
}
