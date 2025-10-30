package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.PatientResponse;
import app.domain.model.Patient;

@Component
public class PatientRestMapper {

    @Autowired
    private PatientBuilder patientBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public Patient toDomain(PatientRequest req) throws Exception {
        return patientBuilder.build(
                req.getDocument(),
                req.getFullName(),
                req.getDateOfBirth(),
                req.getGender(),
                req.getAddress(),
                req.getPhoneNumber(),
                req.getEmailAddress(),
                req.getMedicalRecordId(),
                req.getEmergencyContactDocument(),
                req.getHealthInsurancePolicyNumber()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public PatientResponse toResponse(Patient patient) {
        PatientResponse res = new PatientResponse();
        res.setId(patient.getId());
        res.setDocument(patient.getDocument());
        res.setFullName(patient.getFullName());
        res.setDateOfBirth(patient.getDateOfBirth());
        res.setGender(patient.getGender());
        res.setAddress(patient.getAddress());
        res.setPhoneNumber(patient.getPhoneNumber());
        res.setEmailAddress(patient.getEmailAddress());

        // Se validan las relaciones antes de asignar valores para garantizar que no sean nulas.
        res.setMedicalRecordId(patient.getMedicalRecord() != null ? patient.getMedicalRecord().getId() : 0);
        res.setEmergencyContactDocument(patient.getEmergencyContact() != null ? patient.getEmergencyContact().getDocument() : 0);
        res.setHealthInsurancePolicyNumber(patient.getHealthInsurance() != null ? patient.getHealthInsurance().getPolicyNumber() : 0);

        return res;
    }
}
