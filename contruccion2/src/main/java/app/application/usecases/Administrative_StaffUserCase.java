package app.application.usecases;

import app.domain.model.EmergencyContact;
import app.domain.model.HealthInsurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.*;

import java.util.List;

public class Administrative_StaffUserCase {

    private CreatePatientService createPatientService;
    private SearchPatient searchPatientByDocumentService;

    private CreateEmergencyContactService createEmergencyContactService;
    private SearchEmergencyContact searchEmergencyContactByPatientService;

    private CreateHealthInsuranceService createHealthInsuranceService;
    private SearchHealthInsurance searchHealthInsuranceByPatientService;

    private CreateInvoiceService createInvoiceService;
    private SearchInvoice searchInvoiceByPatientService;

    // Crear y buscar paciente
    public void createPatient (Patient patient) throws Exception{
        createPatientService.create(patient);
    }
    public Patient searchPatientByDocument(Patient patient) throws Exception {
        return searchPatientByDocumentService.search(patient);
    }


    // Crear y buscar contacto de emergencia
    public void createEmergencyContact (EmergencyContact contact) throws Exception{
        createEmergencyContactService.create(contact);
    }
    public EmergencyContact searchEmergencyContact(Patient patient) throws Exception{
        return searchEmergencyContactByPatientService.search(patient);
    }

    // Crear y buscar seguro médico
    public void createHealthInsurance (HealthInsurance healthInsurance) throws Exception{
        createHealthInsuranceService.create(healthInsurance);
    }
    public HealthInsurance searchHealthInsurance (Patient patient) throws Exception{
        return searchHealthInsuranceByPatientService.search(patient);
    }

    // Crear y buscar factura
    public void createInvoice(Invoice invoice) throws Exception {
        createInvoiceService.createInvoice(invoice);
    }

    public List<Invoice> searchInvoice(Patient patient) throws Exception {
        return searchInvoiceByPatientService.search(patient);
    }


}
