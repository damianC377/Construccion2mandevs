package app.adapter.in.client;

import app.adapter.in.builder.MedicationInventoryBuilder;
import app.adapter.in.builder.ProcedureInventoryBuilder;
import app.adapter.in.builder.DiagnosticTestInventoryBuilder;
import app.application.usecases.SupportUserCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.MedicationInventory;
import app.domain.model.ProcedureInventory;
import app.domain.model.DiagnosticTestInventory;

import java.util.Scanner;

public class SupportClient {

    // Mostrar menú principal
    private static final String MENU = """
            Ingrese una opción:
             1. Crear en inventario
             2. Buscar en inventario
             3. Cerrar sesión""";

    // Mostrar menú de creación
    private static final String MENU_CREATE = """
            Ingrese qué desea crear:
             1. Medicamento
             2. Procedimiento
             3. Test diagnóstico
             4. Volver""";

    // Menú de búsqueda
    private static final String MENU_SEARCH = """
            Ingrese qué desea buscar:
             1. Medicamento
             2. Procedimiento
             3. Test diagnóstico
             4. Volver""";

    private static Scanner sc = new Scanner(System.in);

    private SupportUserCase supportUserCase;
    private MedicationInventoryBuilder medicationInventoryBuilder;
    private ProcedureInventoryBuilder procedureInventoryBuilder;
    private DiagnosticTestInventoryBuilder diagnosticTestInventoryBuilder;
    private LoginUseCase loginUseCase;

    // Iniciar sesión y mantener el menú
    public void session() {
        while (loginUseCase.getUserCurrent() != null) {
            menu();
        }
    }

    // Menú principal
    private void menu() {
        System.out.println(MENU);
        String option = sc.nextLine();
        try {
            switch (option) {
                case "1": {
                    menuCreate();
                    break;
                }
                case "2": {
                    menuSearch();
                    break;
                }
                case "3": {
                    System.out.println("Hasta luego, cerrando sesión...");
                    loginUseCase.logout();
                    break;
                }
                default: {
                    System.out.println("Ingrese una opción válida");
                }
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
                case "1": {
                    MedicationInventory medication = readMedicationData();
                    supportUserCase.createMedication(medication);
                    break;
                }
                case "2": {
                    ProcedureInventory procedure = readProcedureData();
                    supportUserCase.createProcedure(procedure);
                    break;
                }
                case "3": {
                    DiagnosticTestInventory test = readDiagnosticTestData();
                    supportUserCase.createDiagnosticTest(test);
                    break;
                }
                case "4": {
                    back = true;
                    break;
                }
                default: {
                    System.out.println("Ingrese una opción válida");
                }
            }
        }
    }

    // Menú de búsqueda
    private void menuSearch() {
        boolean back = false;
        while (!back) {
            System.out.println(MENU_SEARCH);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buscar medicamento"); // placeholder
                    break;
                case "2":
                    System.out.println("Buscar procedimiento"); // placeholder
                    break;
                case "3":
                    System.out.println("Buscar test diagnóstico"); // placeholder
                    break;
                case "4":
                    back = true; // Regresar al menú anterior
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }


    // Leer datos de medicamento
    private MedicationInventory readMedicationData() throws Exception {
        System.out.println("Ingrese el nombre del medicamento:");
        String name = sc.nextLine();
        System.out.println("Ingrese el costo del medicamento:");
        String cost = sc.nextLine();
        return medicationInventoryBuilder.build(name, cost);
    }

    // Leer datos de procedimiento
    private ProcedureInventory readProcedureData() throws Exception {
        System.out.println("Ingrese el nombre del procedimiento:");
        String name = sc.nextLine();
        System.out.println("Ingrese el costo del procedimiento:");
        String cost = sc.nextLine();
        return procedureInventoryBuilder.build(name, cost);
    }

    // Leer datos de test diagnóstico
    private DiagnosticTestInventory readDiagnosticTestData() throws Exception {
        System.out.println("Ingrese el nombre del test diagnóstico:");
        String name = sc.nextLine();
        System.out.println("Ingrese el costo del test diagnóstico:");
        String cost = sc.nextLine();
        return diagnosticTestInventoryBuilder.build(name, cost);
    }
}
