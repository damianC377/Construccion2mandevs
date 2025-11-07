package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.DiagnosticTestInventoryRestMapper;
import app.adapter.rest.mapper.MedicationInventoryRestMapper;
import app.adapter.rest.mapper.ProcedureInventoryRestMapper;
import app.adapter.rest.request.DiagnosticTestInventoryRequest;
import app.adapter.rest.request.MedicationInventoryRequest;
import app.adapter.rest.request.ProcedureInventoryRequest;
import app.adapter.rest.response.DiagnosticTestInventoryResponse;
import app.adapter.rest.response.MedicationInventoryResponse;
import app.adapter.rest.response.ProcedureInventoryResponse;
import app.application.usecases.SupportUseCase;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.MedicationInventory;
import app.domain.model.ProcedureInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support")
@PreAuthorize("hasRole('SUPPORT')")
public class SupportController {

    @Autowired
    private SupportUseCase supportUseCase;

    @Autowired
    private MedicationInventoryRestMapper medicationInventoryRestMapper;
    @Autowired
    private ProcedureInventoryRestMapper procedureInventoryRestMapper;
    @Autowired
    private DiagnosticTestInventoryRestMapper diagnosticTestInventoryRestMapper;

    // Crear medicamento
    @PostMapping("/medications")
    public ResponseEntity<MedicationInventoryResponse> createMedication(@RequestBody MedicationInventoryRequest request) throws Exception {
        MedicationInventory medication = medicationInventoryRestMapper.toDomain(request);
        supportUseCase.createMedication(medication);
        return new ResponseEntity<>(medicationInventoryRestMapper.toResponse(medication), HttpStatus.CREATED);
    }

    // Buscar medicamento por ID
    @GetMapping("/medications/{id}")
    public ResponseEntity<MedicationInventoryResponse> searchMedication(@PathVariable Long id) throws Exception {
        MedicationInventory medication = new MedicationInventory();
        medication.setId(id);
        MedicationInventory found = supportUseCase.searchMedication(medication);
        return ResponseEntity.ok(medicationInventoryRestMapper.toResponse(found));
    }

    // Crear procedimiento
    @PostMapping("/procedures")
    public ResponseEntity<ProcedureInventoryResponse> createProcedure(@RequestBody ProcedureInventoryRequest request) throws Exception {
        ProcedureInventory procedure = procedureInventoryRestMapper.toDomain(request);
        supportUseCase.createProcedure(procedure);
        return new ResponseEntity<>(procedureInventoryRestMapper.toResponse(procedure), HttpStatus.CREATED);
    }

    // Buscar procedimiento por ID
    @GetMapping("/procedures/{id}")
    public ResponseEntity<ProcedureInventoryResponse> searchProcedure(@PathVariable Long id) throws Exception {
        ProcedureInventory procedure = new ProcedureInventory();
        procedure.setId(id);
        ProcedureInventory found = supportUseCase.searchProcedure(procedure);
        return ResponseEntity.ok(procedureInventoryRestMapper.toResponse(found));
    }

    // Crear ayuda diagnóstica
    @PostMapping("/diagnostic-tests")
    public ResponseEntity<DiagnosticTestInventoryResponse> createDiagnosticTest(@RequestBody DiagnosticTestInventoryRequest request) throws Exception {
        DiagnosticTestInventory diagnosticTest = diagnosticTestInventoryRestMapper.toDomain(request);
        supportUseCase.createDiagnosticTest(diagnosticTest);
        return new ResponseEntity<>(diagnosticTestInventoryRestMapper.toResponse(diagnosticTest), HttpStatus.CREATED);
    }

    // Buscar ayuda diagnóstica por ID
    @GetMapping("/diagnostic-tests/{id}")
    public ResponseEntity<DiagnosticTestInventoryResponse> searchDiagnosticTest(@PathVariable Long id) throws Exception {
        DiagnosticTestInventory diagnosticTest = new DiagnosticTestInventory();
        diagnosticTest.setId(id);
        DiagnosticTestInventory found = supportUseCase.searchDiagnosticTest(diagnosticTest);
        return ResponseEntity.ok(diagnosticTestInventoryRestMapper.toResponse(found));
    }
}
