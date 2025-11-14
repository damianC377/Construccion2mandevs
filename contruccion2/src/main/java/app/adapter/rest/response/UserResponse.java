package app.adapter.rest.response;

public class UserResponse {
    private long document;
    private String userName;
    private String role;

    public long getDocument() { return document; }
    public void setDocument(long document) { this.document = document; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
