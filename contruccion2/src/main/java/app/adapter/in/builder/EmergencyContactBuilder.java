package app.adapter.in.builder;

import app.adapter.in.validators.EmergencyContactValidator;
import app.domain.model.EmergencyContact;
import app.domain.model.Patient;

public class EmergencyContactBuilder {

    private EmergencyContactValidator emergencyContactValidator;

    public EmergencyContact build(String name, String relationship, String phoneNumber) throws Exception {

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(emergencyContactValidator.nameValidator(name));
        emergencyContact.setRelationship(emergencyContactValidator.relationshipValidator(relationship));
        emergencyContact.setPhoneNumber(emergencyContactValidator.phoneNumberValidator(phoneNumber));

        return emergencyContact;
    }
}
