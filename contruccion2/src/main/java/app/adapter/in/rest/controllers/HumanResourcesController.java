package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.UserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.Human_ResourcesUseCase;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/human-resources")
@PreAuthorize("hasRole('HUMAN_RESOURCES')")
public class HumanResourcesController {

    @Autowired
    private Human_ResourcesUseCase humanResourcesUseCase;

    @Autowired
    private UserRestMapper userRestMapper;

    // Crear doctor
    @PostMapping("/doctors")
    public ResponseEntity<UserResponse> createDoctor(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createDoctor(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Crear nurse
    @PostMapping("/nurses")
    public ResponseEntity<UserResponse> createNurse(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createNurse(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Crear administrador
    @PostMapping("/administrators")
    public ResponseEntity<UserResponse> createAdministrator(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createADMINISTRATOR(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Crear administrative staff
    @PostMapping("/administrative-staff")
    public ResponseEntity<UserResponse> createAdministrativeStaff(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createADMINISTRATIVE_STAFF(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Crear human resources user
    @PostMapping("/human-resources")
    public ResponseEntity<UserResponse> createHumanResources(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createHUMAN_RESOURCES(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Crear support (nota: usecase establece role DOCTOR en implementación actual)
    @PostMapping("/support")
    public ResponseEntity<UserResponse> createSupport(@RequestBody UserRequest request) throws Exception {
        User user = userRestMapper.toDomain(request);
        humanResourcesUseCase.createSUPPORT(user);
        return new ResponseEntity<>(userRestMapper.toResponse(user), HttpStatus.CREATED);
    }

    // Actualizar usuario por documento
    @PutMapping("/users/{document}")
    public ResponseEntity<Void> updateUser(@PathVariable String document, @RequestBody UserRequest request) throws Exception {
        User newdata = userRestMapper.toDomain(request);
        humanResourcesUseCase.updateUser(Long.parseLong(document), newdata);
        return ResponseEntity.noContent().build();
    }

}
