package app.config;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserPort userPort;

    @Override
    public void run(String... args) throws Exception {
        try {
            User probe = new User();
            probe.setUserName("userRh");
            User existing = null;
            try {
                existing = userPort.findByUserName(probe);
            } catch (Exception ignored) {
                // Adapter may throw; treat as not found
            }

            if (existing == null) {
                User userRh = new User();
                userRh.setFullName("User RH");
                userRh.setDocument(99999999L);
                userRh.setUserName("userRh");
                userRh.setPassword("userRh");
                userRh.setRole(Role.HUMAN_RESOURCES);
                // Fill required non-null fields for UserEntity
                userRh.setEmailAddress("userrh@example.com");
                userRh.setPhoneNumber("1234567890");

                userPort.save(userRh);
                System.out.println("Created default HR user 'userRh'");
            } else {
                System.out.println("Default HR user already exists");
            }
        } catch (Exception e) {
            // Log but don't fail startup
            System.err.println("DataInitializer failed: " + e.getMessage());
        }
    }
}
