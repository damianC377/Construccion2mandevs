package app.adapter.in.client;

import java.util.Scanner;
import app.adapter.in.builder.HealthInsuranceBuilder;
import app.application.usecases.Administrative_StaffUserCase;
import app.application.usecases.LoginUseCase;
import app.domain.model.HealthInsurance;


public class Administrative_StaffClient {
	
	private static Scanner sc = new Scanner(System.in);
	private Administrative_StaffUserCase administrative_StaffUserCase;
	private HealthInsuranceBuilder healthInsuranceBuilder;
	private LoginUseCase loginUseCase;
	
	private static String MENU = """
			Ingrese una de las opciones:
             1. Crear paciente
             2. Crear Seguro de vida
             3.	Salir""";
	
	public void session() {
        while (loginUseCase.getUserCurrent() != null) {
        menu();
        }
    }
	
	public void menu() {
		try {
			System.out.println(MENU);
			String option = sc.nextLine();
			
			switch(option) {
				case "1":{
					//crear paciente
				}
				
				case "2":{
					//Buscar paciente
					
				}
				
				case "3":{
					//Crear Seguro de vida
					HealthInsurance Insurance = readHealthInsurance();
					administrative_StaffUserCase.createHealthInsurance(Insurance);
				}
				
				case "4":{
					//Buscar compañia de seguro
				}
				
				case "5":{
					System.out.println("Hasta luego, cerrando sesión...");
	                loginUseCase.logout();
				}
			
			}
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	private	HealthInsurance readHealthInsurance() throws Exception {
		System.out.println("Digita el nombre de la compañia: ");
		String companyName = sc.nextLine();
		
		System.out.println("Digita el numero de la poliza");
		String policyNumber = sc.nextLine();
		
		System.out.println("Ingrese la fechade finalización (yyyy-mm-dd):");
        String endDate = sc.nextLine();
        
        System.out.println("Esta activo el seguro? (true/false): ");
        String active = sc.nextLine();
        
        return healthInsuranceBuilder.build(companyName, policyNumber,active, endDate);
	}
	
	
	
}
