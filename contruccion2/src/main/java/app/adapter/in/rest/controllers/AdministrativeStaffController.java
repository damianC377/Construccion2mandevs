package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.EmergencyContactRestMapper;
import app.adapter.rest.mapper.HealthInsuranceRestMapper;
import app.adapter.rest.mapper.InvoiceRestMapper;
import app.adapter.rest.mapper.PatientRestMapper;
import app.adapter.rest.request.EmergencyContactRequest;
import app.adapter.rest.request.HealthInsuranceRequest;
import app.adapter.rest.request.InvoiceRequest;
import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.EmergencyContactResponse;
import app.adapter.rest.response.HealthInsuranceResponse;
import app.adapter.rest.response.InvoiceResponse;
import app.adapter.rest.response.PatientResponse;
import app.application.usecases.AdministrativeStaffUseCase;
import app.domain.model.EmergencyContact;
import app.domain.model.HealthInsurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrative")
@PreAuthorize("hasRole('ADMINISTRATIVE_STAFF')")
public class AdministrativeStaffController {

    @Autowired
    private AdministrativeStaffUseCase administrativeStaffUseCase;

    @Autowired
    private PatientRestMapper patientRestMapper;
    @Autowired
    private EmergencyContactRestMapper emergencyContactRestMapper;
    @Autowired
    private HealthInsuranceRestMapper healthInsuranceRestMapper;
    @Autowired
    private InvoiceRestMapper invoiceRestMapper;


    // Crear paciente
    @PostMapping("/patients")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest request) throws Exception {
        Patient patient = patientRestMapper.toDomain(request);
        administrativeStaffUseCase.createPatient(patient);
        return new ResponseEntity<>(patientRestMapper.toResponse(patient), HttpStatus.CREATED);
    }

    // Buscar paciente por documento
    @GetMapping("/patients/{document}")
    public ResponseEntity<PatientResponse> searchPatient(@PathVariable String document) throws Exception {
        Patient patient = new Patient();
        patient.setDocument(Long.parseLong(document));
        Patient found = administrativeStaffUseCase.searchPatientByDocument(patient);
        return ResponseEntity.ok(patientRestMapper.toResponse(found));
    }

    // Crear contacto de emergencia
    @PostMapping("/emergency-contacts")
    public ResponseEntity<EmergencyContactResponse> createEmergencyContact(@RequestParam("patientId") String patientId, @RequestBody EmergencyContactRequest request) throws Exception {
        Patient patient = new Patient();
        patient.setId(Long.parseLong(patientId));
        EmergencyContact contact = emergencyContactRestMapper.toDomain(request);
        administrativeStaffUseCase.createEmergencyContact(contact, patient);
        return new ResponseEntity<>(emergencyContactRestMapper.toResponse(contact), HttpStatus.CREATED);
    }

    // Buscar contacto de emergencia por paciente
    @GetMapping("/emergency-contacts/{patientId}")
    public ResponseEntity<EmergencyContactResponse> searchEmergencyContact(@PathVariable Long patientId) throws Exception {
        Patient patient = new Patient();
        patient.setId(patientId);
        EmergencyContact found = administrativeStaffUseCase.searchEmergencyContact(patient);
        return ResponseEntity.ok(emergencyContactRestMapper.toResponse(found));
    }

    // Crear seguro médico
    @PostMapping("/health-insurances")
    public ResponseEntity<HealthInsuranceResponse> createHealthInsurance(@RequestBody HealthInsuranceRequest request) throws Exception {
        HealthInsurance insurance = healthInsuranceRestMapper.toDomain(request);
        administrativeStaffUseCase.createHealthInsurance(insurance);
        return new ResponseEntity<>(healthInsuranceRestMapper.toResponse(insurance), HttpStatus.CREATED);
    }

    // Buscar seguro médico por paciente
    @GetMapping("/health-insurances/patient/{patientId}")
    public ResponseEntity<HealthInsuranceResponse> searchHealthInsuranceByPatient(@PathVariable Long patientId) throws Exception {
        Patient patient = new Patient();
        patient.setId(patientId);
        HealthInsurance found = administrativeStaffUseCase.searchHealthInsuranceBypatient(patient);
        return ResponseEntity.ok(healthInsuranceRestMapper.toResponse(found));
    }

    // Buscar seguro médico por número de póliza
    @GetMapping("/health-insurances/policy/{policyNumber}")
    public ResponseEntity<HealthInsuranceResponse> searchHealthInsuranceByPolicy(@PathVariable String policyNumber) throws Exception {
        HealthInsurance found = administrativeStaffUseCase.searchHealthInsuranceByPolicyNumber(policyNumber);
        return ResponseEntity.ok(healthInsuranceRestMapper.toResponse(found));
    }

    // Crear factura
    @PostMapping("/invoices")
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request) throws Exception {
        Invoice invoice = invoiceRestMapper.toDomain(request);
        administrativeStaffUseCase.createInvoice(invoice);
        return new ResponseEntity<>(invoiceRestMapper.toResponse(invoice), HttpStatus.CREATED);
    }

    // Buscar facturas por paciente
    @GetMapping("/invoices/patient/{patientId}")
    public ResponseEntity<List<InvoiceResponse>> searchInvoices(@PathVariable Long patientId) throws Exception {
        Patient patient = new Patient();
        patient.setId(patientId);
        List<Invoice> invoices = administrativeStaffUseCase.searchInvoice(patient);
        List<InvoiceResponse> res = invoices.stream().map(invoiceRestMapper::toResponse).toList();
        return ResponseEntity.ok(res);
    }
}

