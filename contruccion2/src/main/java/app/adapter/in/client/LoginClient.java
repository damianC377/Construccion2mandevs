package app.adapter.in.client;

import java.util.Scanner;

import app.adapter.in.builder.LoginBuilder;
import app.application.usecases.LoginUseCase;
import app.domain.model.User;

public class LoginClient {
	
	private static Scanner sc = new Scanner(System.in);
	private LoginBuilder loginBuilder;
	private LoginUseCase loginUseCase;
	
	public void start() {
		try {
			
			System.out.println("=== Iniciar Sesion ===");
			System.out.println("Digita nombre de usuario: ");
			String userName = sc.nextLine();
			
			System.out.println("Digita clave de usuario: ");
			String password = sc.nextLine();
			
			User user = loginBuilder.build(userName, password);
			
			User userlogged = loginUseCase.loginUseCase(userName, password);
			
			System.out.println("Bienvenido: "+ userlogged.getFullName());
			
		}catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}
}
