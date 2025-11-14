package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.DiagnosticTestInventoryRestMapper;
import app.adapter.rest.mapper.MedicationInventoryRestMapper;
import app.adapter.rest.mapper.ProcedureInventoryRestMapper;
import app.adapter.rest.mapper.MedicalRecordRestMapper;
import app.adapter.rest.mapper.MedicalOrderRestMapper;
import app.adapter.rest.mapper.PatientRestMapper;
import app.adapter.rest.request.DiagnosticTestInventoryRequest;
import app.adapter.rest.request.MedicationInventoryRequest;
import app.adapter.rest.request.ProcedureInventoryRequest;
import app.adapter.rest.request.MedicalRecordRequest;
import app.adapter.rest.request.MedicalOrderRequest;
import app.adapter.rest.response.DiagnosticTestInventoryResponse;
import app.adapter.rest.response.MedicationInventoryResponse;
import app.adapter.rest.response.ProcedureInventoryResponse;
import app.adapter.rest.response.MedicalRecordResponse;
import app.adapter.rest.response.MedicalOrderResponse;
import app.adapter.rest.response.PatientResponse;
import app.application.usecases.DoctorUseCase;
import app.application.usecases.SupportUseCase;
import app.domain.model.DiagnosticTestInventory;
import app.domain.model.MedicationInventory;
import app.domain.model.ProcedureInventory;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.model.MedicalOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    @Autowired
    private DoctorUseCase doctorUseCase;

    @Autowired
    private SupportUseCase supportUseCase;

    @Autowired
    private MedicationInventoryRestMapper medicationInventoryRestMapper;
    @Autowired
    private ProcedureInventoryRestMapper procedureInventoryRestMapper;
    @Autowired
    private DiagnosticTestInventoryRestMapper diagnosticTestInventoryRestMapper;
    @Autowired
    private MedicalRecordRestMapper medicalRecordRestMapper;
    @Autowired
    private MedicalOrderRestMapper medicalOrderRestMapper;
    @Autowired
    private PatientRestMapper patientRestMapper;

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

    // Crear historia clínica
    @PostMapping("/medical-records")
    public ResponseEntity<MedicalRecordResponse> createMedicalRecord(@RequestBody MedicalRecordRequest request) throws Exception {
        MedicalRecord record = medicalRecordRestMapper.toDomain(request);
        doctorUseCase.createMedicalRecord(record);
        return new ResponseEntity<>(medicalRecordRestMapper.toResponse(record), HttpStatus.CREATED);
    }

    // Obtener historia clínica por documento de paciente
    @GetMapping("/medical-records/patient/{document}")
    public ResponseEntity<MedicalRecordResponse> getMedicalRecord(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        MedicalRecord found = doctorUseCase.searchMedicalRecord(patient);
        return ResponseEntity.ok(medicalRecordRestMapper.toResponse(found));
    }

    // Crear orden médica (desde DoctorUseCase)
    @PostMapping("/medical-orders")
    public ResponseEntity<MedicalOrderResponse> createMedicalOrder(@RequestBody MedicalOrderRequest request) throws Exception {
        MedicalOrder order = medicalOrderRestMapper.toDomain(request);
        doctorUseCase.createMedicalOrder(order);
        return new ResponseEntity<>(medicalOrderRestMapper.toResponse(order), HttpStatus.CREATED);
    }

    // Obtener órdenes médicas por documento de paciente
    @GetMapping("/medical-orders/patient/{document}")
    public ResponseEntity<List<MedicalOrderResponse>> getMedicalOrders(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        List<MedicalOrder> orders = doctorUseCase.searchMedicalOrder(patient);
        List<MedicalOrderResponse> res = orders.stream().map(medicalOrderRestMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    // Buscar paciente por documento (desde DoctorUseCase)
    @GetMapping("/patients/{document}")
    public ResponseEntity<PatientResponse> getPatientByDocument(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        Patient found = doctorUseCase.searchPatientByDocument(patient);
        return ResponseEntity.ok(patientRestMapper.toResponse(found));
    }

}
