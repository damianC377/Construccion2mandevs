package app.domain.model;

public class EmergencyContact {
    private long document;
    private String name;
    private String relationship;
    private String phoneNumber;

    // Getters

    public long getDocument() { return document; }

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


    public void setDocument(long document) { this.document = document; }

    public void setName(String name) { this.name = name; }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
