package site.nomoreparties.stellarburgers.model;

public class RegisterUserRequest {
    private String email;
    private String password;
    private String name;

    public RegisterUserRequest(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public RegisterUserRequest(){}
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
