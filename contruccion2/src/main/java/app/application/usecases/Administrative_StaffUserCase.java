package app.application.usecases;

import app.domain.model.EmergencyContact;
import app.domain.model.HealthInsurance;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.*;

import java.util.List;

public class Administrative_StaffUserCase {

    private CreatePatient createPatient;
    private SearchPatientByDocument searchPatientByDocument;

    private CreateEmergencyContact createEmergencyContact;
    private SearchEmergencyContactByPatient searchEmergencyContact;

    private CreateHealthInsurance createHealthInsurance;
    private SearchHealthInsuranceByPatient searchHealthInsuranceByPatient;

    private CreateInvoice createInvoice;
    private SearchInvoiceByPatient searchInvoiceByPatient;

    // Crear y buscar paciente
    public void createPatient (Patient patient) throws Exception{
        createPatient.create(patient);
    }
    public Patient searchPatientByDocument(Patient patient) throws Exception {
        return searchPatientByDocument.search(patient);
    }


    // Crear y buscar contacto de emergencia
    public void createEmergencyContact (EmergencyContact contact, Patient patient) throws Exception{
        createEmergencyContact.create(contact, patient);
    }
    public EmergencyContact searchEmergencyContact(Patient patient) throws Exception{
        return searchEmergencyContact.search(patient);
    }

    // Crear y buscar seguro médico
    public void createHealthInsurance (HealthInsurance healthInsurance, Patient patient) throws Exception{
        createHealthInsurance.create(healthInsurance, patient);
    }
    public HealthInsurance searchHealthInsurance (Patient patient) throws Exception{
        return searchHealthInsuranceByPatient.search(patient);
    }

    // Crear y buscar factura
    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.create(invoice);
    }
    public List<Invoice> searchInvoice(Patient patient) throws Exception {
        return searchInvoiceByPatient.search(patient);
    }


}
