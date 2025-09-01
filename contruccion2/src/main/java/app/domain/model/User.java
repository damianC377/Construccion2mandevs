package app.domain.model;

//Extend es una herencia, coge atributos de person
public class User extends Person{
    public String userName;
    public String password;

    // Getters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
