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
            // Buscar si ya existe el usuario admin
            User probe = new User();
            probe.setUserName("admin");

            User existing = null;
            try {
                existing = userPort.findByUserName(probe);
            } catch (Exception ignored) {
                // Ignorar errores del adapter y tratar como "no existe"
            }

            if (existing == null) {
                // Crear usuario admin por defecto
                User admin = new User();
                admin.setFullName("Administrador del Sistema");
                admin.setDocument(11111111L);
                admin.setUserName("admin");

                // Encriptar la contraseña
                admin.setPassword(passwordEncoder.encode("admin"));

                admin.setRole(Role.ADMINISTRATOR);
                admin.setEmailAddress("admin@example.com");
                admin.setPhoneNumber("3000000000");

                userPort.save(admin);

                System.out.println("✅ Usuario ADMIN creado por defecto");
                System.out.println("   Usuario: admin");
                System.out.println("   Contraseña: admin");
            } else {
                System.out.println("ℹ️  El usuario ADMIN ya existe");
            }

        } catch (Exception e) {
            System.err.println("❌ Error en DataInitializer: " + e.getMessage());
        }
    }
}
