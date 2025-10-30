package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.rest.request.EmergencyContactRequest;
import app.adapter.rest.response.EmergencyContactResponse;
import app.domain.model.EmergencyContact;

@Component
public class EmergencyContactRestMapper {

    @Autowired
    private EmergencyContactBuilder emergencyContactBuilder;

    // Convierte un objeto Request a un objeto del dominio
    public EmergencyContact toDomain(EmergencyContactRequest req) throws Exception {
        return emergencyContactBuilder.build(
                req.getDocument(),
                req.getName(),
                req.getRelationship(),
                req.getPhoneNumber()
        );
    }

    // Convierte un objeto del dominio a un objeto Response
    public EmergencyContactResponse toResponse(EmergencyContact contact) {
        EmergencyContactResponse res = new EmergencyContactResponse();
        res.setDocument(contact.getDocument());
        res.setName(contact.getName());
        res.setRelationship(contact.getRelationship());
        res.setPhoneNumber(contact.getPhoneNumber());
        return res;
    }
}
