package app.adapter.in.client;

import app.adapter.in.builder.UserBuilder;
import app.application.usecases.Human_ResourcesUseCase;
import app.domain.model.User;

import java.util.Scanner;

public class Human_ResourcesClient {

    // Mostrar menu
    private static final String MENU = """
            Ingrese una de las opciones:
             1. Crear doctor
             2. Crear enfermera
             3. Crear administrador
             4. Crear personal administrativo
             5. Crear personal de soporte
             6. Crear personal de recursos humanos
             7. Salir""";

    private static Scanner sc = new Scanner(System.in);
    private Human_ResourcesUseCase humanResourcesUseCase;
    private UserBuilder userBuilder;

    // Iniciar sesión y mantener el menú
    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    // Menu de opciones
    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = sc.nextLine();

            switch (option) {
                case "1": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createDoctor(user);
                    return true;
                }
                case "2": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createNurse(user);
                    return true;
                }
                case "3": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createADMINISTRATOR(user);
                    return true;
                }
                case "4": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createADMINISTRATIVE_STAFF(user);
                    return true;
                }
                case "5": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createSUPPORT(user);
                    return true;
                }
                case "6": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createHUMAN_RESOURCES(user);
                    return true;
                }
                case "7": {
                    System.out.println("Hasta luego, cerrando sesión...");
                    return false;
                }
                default: {
                    System.out.println("Ingrese una opción válida.");
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    // Pedir datos del usuario por consola
    private User readInfoFromUser() throws Exception {
        System.out.println("Ingrese el nombre completo:");
        String fullName = sc.nextLine();

        System.out.println("Ingrese la cédula:");
        String document = sc.nextLine();

        System.out.println("Ingrese el correo electrónico:");
        String emailAddress = sc.nextLine();

        System.out.println("Ingrese el teléfono:");
        String phoneNumber = sc.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (yyyy-mm-dd):");
        String dateOfBirth = sc.nextLine();

        System.out.println("Ingrese la dirección:");
        String address = sc.nextLine();

        System.out.println("Ingrese el nombre de usuario:");
        String userName = sc.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = sc.nextLine();

        // Construir el objeto User con el UserBuilder
        return userBuilder.build(fullName, document, emailAddress, phoneNumber, dateOfBirth, address, userName, password);
    }
}





