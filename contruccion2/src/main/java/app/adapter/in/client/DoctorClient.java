package app.adapter.in.client;

import app.adapter.in.builder.MedicalOrderBuilder;
import app.adapter.in.builder.MedicalRecordBuilder;
import app.application.usecases.DoctorUserCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorClient {

    // Mostrar menús
    private static final String MENU_MAIN = """
            Menú principal:
             1. Crear
             2. Buscar
             3. Cerrar sesión""";

    private static final String MENU_CREATE = """
            Crear:
             1. Historia clínica
             2. Orden médica
             3. Volver""";

    private static final String MENU_SEARCH = """
            Ingrese opción de búsqueda:
            1. Buscar historia clínica
            2. Buscar orden médica
            3. Buscar Paciente
            4. Regresar""";

    private static Scanner sc = new Scanner(System.in);


    private DoctorUserCase doctorUserCase;
    private MedicalRecordBuilder medicalRecordBuilder;
    private MedicalOrderBuilder medicalOrderBuilder;
    private LoginUseCase loginUseCase;

    // Iniciar sesión y mantener el menú
    public void session() {
        while (loginUseCase.getUserCurrent() != null) {
            menuMain();
        }
    }

    // Menú principal
    private void menuMain() {
        System.out.println(MENU_MAIN);
        String option = sc.nextLine();
        try {
            switch (option) {
                case "1": menuCreate(); break; // Submenú de creación
                case "2":
                    System.out.println("Buscar historia clínica u órdenes médicas"); // placeholder
                    break;
                case "3":
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

    // Menú de creación
    private void menuCreate() throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println(MENU_CREATE);
            String option = sc.nextLine();
            switch (option) {
                case "1": createMedicalRecord(); break;
                case "2": createMedicalOrder(); break;
                case "3": back = true; break;
                default: System.out.println("Ingrese una opción válida");
            }
        }
    }

    // Menú de búsqueda (placeholder)
    private void menuSearch() {
        boolean back = false;
        while (!back) {
            System.out.println(MENU_SEARCH);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buscar historia clínica");
                    break;
                case "2":
                    System.out.println("Buscar orden médica");
                    break;
                case "3":
                    System.out.println("Buscar paciente");
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    // Crear historia clínica
    private void createMedicalRecord() throws Exception {
        System.out.println("Documento del paciente:"); String patientDoc = sc.nextLine();
        System.out.println("Documento del doctor:"); String doctorDoc = sc.nextLine();
        System.out.println("Fecha de la orden (yyyy-mm-dd):"); String orderDate = sc.nextLine();
        System.out.println("Motivo de la consulta:"); String consultationReason = sc.nextLine();
        System.out.println("Síntomas:"); String symptoms = sc.nextLine();
        System.out.println("Diagnóstico:"); String diagnosis = sc.nextLine();

        List<MedicalOrder> orders = new ArrayList<>();
        MedicalRecord record = medicalRecordBuilder.build(
                patientDoc, doctorDoc, orderDate, consultationReason, symptoms, diagnosis, orders
        );

        doctorUserCase.createMedicalRecord(record);
        System.out.println("Historia clínica creada correctamente.");
    }

    // Crear orden médica
    // Datos básicos
    private void createMedicalOrder() throws Exception {
        System.out.println("Documento del paciente:"); String patientDoc = sc.nextLine();
        System.out.println("Documento del doctor:"); String doctorDoc = sc.nextLine();
        System.out.println("Número de orden:"); String orderNumber = sc.nextLine();
        System.out.println("Fecha de la orden (yyyy-mm-dd):"); String orderDate = sc.nextLine();

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
                case "4": addMore = false; break;
                default: System.out.println("Opción inválida");
            }
        }

        // Construir la orden médica usando el builder
        MedicalOrder order = medicalOrderBuilder.build(patientDoc, doctorDoc, orderNumber, orderDate, items);
        doctorUserCase.createMedicalOrder(order);
        System.out.println("Orden médica creada correctamente.");
    }

    // Métodos de creación de ítems
    private Order createMedicationOrder() {
        MedicationOrder medicationOrder = new MedicationOrder();
        System.out.println("Dosis:"); medicationOrder.setDosage(sc.nextLine());
        System.out.println("Duración del tratamiento:"); medicationOrder.setTreatmentDuration(sc.nextLine());
        return medicationOrder;
    }

    private Order createProcedureOrder() {
        ProcedureOrder procedureOrder = new ProcedureOrder();
        System.out.println("Frecuencia:"); procedureOrder.setFrequency(sc.nextLine());
        System.out.println("Requiere especialista? (sí/no):");
        procedureOrder.setRequiresSpecialist(sc.nextLine().equalsIgnoreCase("sí"));
        return procedureOrder;
    }

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
