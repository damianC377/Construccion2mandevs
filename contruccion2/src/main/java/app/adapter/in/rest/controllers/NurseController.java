package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.MedicalRecordRestMapper;
import app.adapter.rest.mapper.MedicalOrderRestMapper;
import app.adapter.rest.mapper.PatientRestMapper;
import app.adapter.rest.request.MedicalRecordRequest;
import app.adapter.rest.request.MedicalOrderRequest;
import app.adapter.rest.response.MedicalRecordResponse;
import app.adapter.rest.response.MedicalOrderResponse;
import app.adapter.rest.response.PatientResponse;
import app.application.usecases.NurseUseCase;
import app.domain.model.MedicalRecord;
import app.domain.model.MedicalOrder;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nurse")
@PreAuthorize("hasRole('NURSE')")
public class NurseController {

    @Autowired
    private NurseUseCase nurseUseCase;

    @Autowired
    private MedicalRecordRestMapper medicalRecordRestMapper;

    @Autowired
    private MedicalOrderRestMapper medicalOrderRestMapper;

    @Autowired
    private PatientRestMapper patientRestMapper;

    // Crear historia clínica
    @PostMapping("/medical-records")
    public ResponseEntity<MedicalRecordResponse> createMedicalRecord(@RequestBody MedicalRecordRequest request) throws Exception {
        MedicalRecord record = medicalRecordRestMapper.toDomain(request);
        nurseUseCase.createMedicalRecord(record);
        return new ResponseEntity<>(medicalRecordRestMapper.toResponse(record), HttpStatus.CREATED);
    }

    // Obtener historia clínica por documento de paciente
    @GetMapping("/medical-records/patient/{document}")
    public ResponseEntity<MedicalRecordResponse> getMedicalRecord(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        MedicalRecord found = nurseUseCase.searchMedicalRecord(patient);
        return ResponseEntity.ok(medicalRecordRestMapper.toResponse(found));
    }

    // Crear orden médica
    @PostMapping("/medical-orders")
    public ResponseEntity<MedicalOrderResponse> createMedicalOrder(@RequestBody MedicalOrderRequest request) throws Exception {
        MedicalOrder order = medicalOrderRestMapper.toDomain(request);
        nurseUseCase.createMedicalOrder(order);
        return new ResponseEntity<>(medicalOrderRestMapper.toResponse(order), HttpStatus.CREATED);
    }

    // Obtener órdenes médicas por documento de paciente
    @GetMapping("/medical-orders/patient/{document}")
    public ResponseEntity<List<MedicalOrderResponse>> getMedicalOrders(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        List<MedicalOrder> orders = nurseUseCase.searchMedicalOrder(patient);
        List<MedicalOrderResponse> res = orders.stream().map(medicalOrderRestMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    // Buscar paciente por documento
    @GetMapping("/patients/{document}")
    public ResponseEntity<PatientResponse> getPatientByDocument(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        Patient found = nurseUseCase.searchPatientByDocument(patient);
        return ResponseEntity.ok(patientRestMapper.toResponse(found));
    }

}
