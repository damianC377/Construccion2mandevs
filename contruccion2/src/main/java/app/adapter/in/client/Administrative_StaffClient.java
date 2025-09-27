package app.adapter.in.client;

import java.util.Scanner;

import app.adapter.in.builder.HealthInsuranceBuilder;
import app.application.usecases.Administrative_StaffUserCase;
import app.application.usecases.LoginUseCase;


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
	
	
	
}
