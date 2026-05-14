package app.infrastructure.config;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserPort userPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Buscar si ya existe el usuario recursos humanos
            User probe = new User();
            probe.setUserName("hr"); // Cambié el username a algo representativo

            User existing = null;
            try {
                existing = userPort.findByUserName(probe);
            } catch (Exception ignored) {
                // Ignorar errores del adapter y tratar como "no existe"
            }

            if (existing == null) {
                // Crear usuario Recursos Humanos por defecto
                User hrUser = new User();
                hrUser.setFullName("Usuario Recursos Humanos");
                hrUser.setDocument(12345678L);
                hrUser.setUserName("hr");
                // Encriptar la contraseña
                hrUser.setPassword(passwordEncoder.encode("hr"));
                hrUser.setRole(Role.HUMAN_RESOURCES);
                hrUser.setEmailAddress("hr@example.com");
                hrUser.setPhoneNumber("3001234567");

                userPort.save(hrUser);

                System.out.println("✅ Usuario HUMAN_RESOURCES creado por defecto");
                System.out.println("   Usuario: hr");
                System.out.println("   Contraseña: hr");
            } else {
                System.out.println("ℹ️  El usuario HUMAN_RESOURCES ya existe");
            }

        } catch (Exception e) {
            System.err.println("❌ Error en DataInitializer: " + e.getMessage());
        }
    }
}
