package site.nomoreparties.stellarburgers.model;

public class RegisterUserResponse {
    private Boolean success;
    private String message;
    private UserData user;
    private  String accessToken;
    private String refreshToken;

    public RegisterUserResponse(Boolean success,String message, UserData user, String accessToken, String refreshToken){
        this.success = success;
        this.message = message;
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
    public RegisterUserResponse(){}

    public Boolean getSuccess() {
        return success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserData getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
