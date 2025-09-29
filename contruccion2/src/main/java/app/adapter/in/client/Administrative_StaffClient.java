package app.adapter.in.client;


import java.util.Scanner;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.in.builder.HealthInsuranceBuilder;
import app.adapter.in.builder.InvoiceBuilder;
import app.application.usecases.Administrative_StaffUserCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.*;

public class Administrative_StaffClient {

    private static final String MENU = """
            Ingrese una opción:
             1. Crear
             2. Buscar
             3. Salir""";

    private static final String MENU_CREATE = """
            Ingrese qué desea crear:
             1. Paciente
             2. Contacto de emergencia
             3. Factura
             4. Volver""";

    private static final String MENU_SEARCH = """
            Ingrese qué desea buscar:
             1. Paciente
             2. Contacto de emergencia
             3. Seguro de salud
             4. Factura
             5. Volver""";

    private static Scanner sc = new Scanner(System.in);

    private Administrative_StaffUserCase staffUseCase;
    private LoginUseCase loginUseCase;

    private PatientBuilder patientBuilder;
    private EmergencyContactBuilder emergencyContactBuilder;
    private HealthInsuranceBuilder healthInsuranceBuilder;
    private InvoiceBuilder invoiceBuilder;

    public void session() {
        while (loginUseCase.getUserCurrent() != null) {
            menu();
        }
    }

    private void menu() {
        System.out.println(MENU);
        String option = sc.nextLine();
        try {
            switch (option) {
                case "1": menuCreate(); break;
                case "2": menuSearch(); break;
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

    // Menú Crear
    private void menuCreate() throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println(MENU_CREATE);
            String option = sc.nextLine();
            switch (option) {
                case "1": {
                    Patient patient = readPatientData();
                    staffUseCase.createPatient(patient);
                    break;
                }
                case "2": {
                    // Buscar paciente primero para asignar contacto
                    Patient patient = readPatientDocumentOnly();
                    EmergencyContact contact = readEmergencyContactData();
                    staffUseCase.createEmergencyContact(contact, patient);
                    break;
                }
                case "3": {
                    Invoice invoice = readInvoiceData();
                    staffUseCase.createInvoice(invoice);
                    break;
                }
                case "4": back = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    // Menú Buscar
    private void menuSearch() {
        boolean back = false;
        while (!back) {
            System.out.println(MENU_SEARCH);
            String option = sc.nextLine();
            switch (option) {
                case "1": System.out.println("Buscar paciente"); break;
                case "2": System.out.println("Buscar contacto de emergencia"); break;
                case "3": System.out.println("Buscar seguro de salud"); break;
                case "4": System.out.println("Buscar factura"); break;
                case "5": back = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    // Métodos para pedir datos
    private Patient readPatientData() throws Exception {
        System.out.println("Documento:"); String document = sc.nextLine();
        System.out.println("Nombre completo:"); String fullName = sc.nextLine();
        System.out.println("Fecha de nacimiento (yyyy-mm-dd):"); String dob = sc.nextLine();
        System.out.println("Género:"); String gender = sc.nextLine();
        System.out.println("Dirección:"); String address = sc.nextLine();
        System.out.println("Teléfono:"); String phone = sc.nextLine();
        System.out.println("Email:"); String email = sc.nextLine();

        Patient patient = patientBuilder.build(document, fullName, dob, gender, address, phone, email);
        
        System.out.println("¿Desea asociar un seguro existente o crear uno nuevo?");
        System.out.println("1. Asociar existente");
        System.out.println("2. Crear nuevo");
        System.out.println("3. No tiene");
        String opt = sc.nextLine();
        
        HealthInsurance insurance = null;
        
        switch (opt){
		case "1": {
			System.out.println("Ingresa el número de la poliza: ");
			String policyNumber = sc.nextLine();
			
			try {
				
				insurance = staffUseCase.searchHealthInsuranceByPolicyNumber(policyNumber);
				
			} catch (Exception e) {
				System.out.println("No se encontró la póliza con ese número.");
			}
			break;
		}
		case "2":{
			insurance = readHealthInsuranceData();
			staffUseCase.createHealthInsurance(insurance);
			System.out.println("Seguro creado y asignado al paciente");
			break;
		}
		case "3":{
			System.out.println("Paciente sin seguro registrado");
			break;
		}
		default:
			throw new IllegalArgumentException("No existe esta opcion. Se continuará sin seguro");
		}
        
        if(insurance != null) {
        	patient.setHealthInsurance(insurance);
        }
        
        return patient;
        
    }

    private Patient readPatientDocumentOnly() throws Exception{
        System.out.println("Documento del paciente:"); long document = Long.parseLong(sc.nextLine());
        Patient patient = new Patient();
        patient.setDocument(document);
        
        return patient;
    }


    private EmergencyContact readEmergencyContactData() throws Exception {
        System.out.println("Nombre:"); String name = sc.nextLine();
        System.out.println("Parentesco:"); String relationship = sc.nextLine();
        System.out.println("Teléfono:"); String phone = sc.nextLine();

        return emergencyContactBuilder.build(name, relationship, phone);
        
    }

    private HealthInsurance readHealthInsuranceData() throws Exception {
        System.out.println("Compañía: "); String company = sc.nextLine();
        System.out.println("Número de póliza: "); String policyNumber = sc.nextLine();
        System.out.println("Activo (s/n): "); String active = sc.nextLine();
        System.out.println("Fecha fin (yyyy-mm-dd): "); String endDate = sc.nextLine();

       return healthInsuranceBuilder.build(company, policyNumber, active, endDate);
    }

    private Invoice readInvoiceData() throws Exception{
        System.out.println("Documento del paciente:"); String patientDocument = sc.nextLine();
        System.out.println("Documento del doctor:"); String doctorDocument = sc.nextLine();
        System.out.println("Número póliza:"); String policyNumber = sc.nextLine();
        System.out.println("Validez en días:"); String validityDays = sc.nextLine();
        System.out.println("Fecha fin de póliza (yyyy-mm-dd):"); String endDate = sc.nextLine();

        return invoiceBuilder.build(patientDocument, doctorDocument, policyNumber, validityDays, endDate, validityDays, endDate, null);
    }
}
