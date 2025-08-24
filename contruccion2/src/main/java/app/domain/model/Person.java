package app.domain.model;

public class Person {
    private long id;
    private String name;
    private long document;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private Role role;

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDocument() {
        return document;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Role getRole() {
        return role;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}


