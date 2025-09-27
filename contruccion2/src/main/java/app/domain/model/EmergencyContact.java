package app.domain.model;

public class EmergencyContact {
    private String name;
    private String relationship;
    private String phoneNumber;

    // Getters

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters

    public void setName(String name) { this.name = name; }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
