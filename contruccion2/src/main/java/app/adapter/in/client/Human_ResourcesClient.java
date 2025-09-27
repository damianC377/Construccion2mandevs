package app.adapter.in.client;

import app.adapter.in.builder.UserBuilder;
import app.application.usecases.Human_ResourcesUseCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.User;
import app.domain.model.enums.Role;

import java.util.Scanner;

public class Human_ResourcesClient {
	
	// Mostrar menu_create
    private static final String MENU = """
            Ingrese una de las opciones:
             1. Crear usuario
             2. Actualizar usuario
             3.	Salir""";

    // Mostrar menu_create
    private static final String MENU_create = """
            Ingrese una de las opciones:
             1. Crear doctor
             2. Crear enfermera
             3. Crear administrador
             4. Crear personal administrativo
             5. Crear personal de soporte
             6. Crear personal de recursos humanos
             7. Volver""";
    
 // Mostrar menu_update
    private static final String MENU_role = """
            Ingrese un Rol:
             1. Doctor
             2. Enfermera
             3. Administrador
             4. Personal administrativo
             5. Personal de soporte
             6. Recursos humanos
             7. Volver""";

    private static Scanner sc = new Scanner(System.in);
    private Human_ResourcesUseCase humanResourcesUseCase;
    private UserBuilder userBuilder;
    private LoginUseCase loginUseCase;

    // Iniciar sesión y mantener el menú
    public void session() {
        while (loginUseCase.getUserCurrent() != null) {
        menu();
        }
    }
    
    private void menu() {
    	try {
    		 System.out.println(MENU);
             String option = sc.nextLine();
    		
             
             switch (option) {
			case "1": {
				menu_create();
				
			}
			case "2": {
				menu_update();
			}
			case "3": {
				System.out.println("Hasta luego, cerrando sesión...");
                loginUseCase.logout();
			}
			default:
				System.out.println("Ingrese una opción válida.");
                break;
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

    // Menu de opciones de creacion de usuarios
    private void menu_create() {
        try {
            System.out.println(MENU_create);
            String option2 = sc.nextLine();

            switch (option2) {
                case "1": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createDoctor(user);
                    break;
                }
                case "2": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createNurse(user);
                    break;
                }
                case "3": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createADMINISTRATOR(user);
                    break;
                }
                case "4": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createADMINISTRATIVE_STAFF(user);
                    break;
                }
                case "5": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createSUPPORT(user);
                    break;
                }
                case "6": {
                    User user = readInfoFromUser();
                    humanResourcesUseCase.createHUMAN_RESOURCES(user);
                    break;
                }
                case "7": {
                	menu();
                    break;
                }
                default: {
                    System.out.println("Ingrese una opción válida.");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
           
        }
    }
    
 // Menu de actualizacion de datos de usuarios
    private void menu_update() {
        try {
        	System.out.println("Ingrese la cedula del usuario");
        	String document = sc.nextLine();
        	
        	User newData = readInfoUpdateFromUser();
        	
        	System.out.println("¿Desea cambiar el rol (s/n): ");
        	String changeRole = sc.nextLine();
            
            
            if(changeRole.equalsIgnoreCase("s")) {
            	
            	System.out.println(MENU_role);
                String roleOption = sc.nextLine();

                switch (roleOption) {
                    case "1": {
                        newData.setRole(Role.DOCTOR);
                        break;
                    }
                    case "2": {
                    	newData.setRole(Role.NURSE);
                        break;
                    }
                    case "3": {
                    	newData.setRole(Role.ADMINISTRATOR);
                        break;
                    }
                    case "4": {
                    	newData.setRole(Role.ADMINISTRATIVE_STAFF);
                        break;
                    }
                    case "5": {
                    	newData.setRole(Role.SUPPORT);
                        break;
                    }
                    case "6": {
                    	newData.setRole(Role.HUMAN_RESOURCES);
                        break;
                    }
                    default: {
                        System.out.println("Ingrese una opción válida.");
                        break;
                    }
                }
                
                humanResourcesUseCase.updateUser(Long.parseLong(document), newData);
                System.out.println("Usuario Actualizado");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
           
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
    
    // Pedir datos del usuario para actulizar por consola
    private User readInfoUpdateFromUser() throws Exception {
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





