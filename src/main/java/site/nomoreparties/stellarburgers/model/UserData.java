package site.nomoreparties.stellarburgers.model;

public class UserData {
    private String email;
    private String name;

    public UserData(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UserData() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
