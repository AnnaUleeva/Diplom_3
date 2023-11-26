package site.nomoreparties.stellarburgers.model;

public class LoginUserResponse {
    private Boolean success;
    private String accessToken;
    private String refreshToken;
    private UserData user;
    private String message;

    public LoginUserResponse(Boolean success, String accessToken, String refreshToken, UserData user, String message) {
        this.success = success;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
        this.message = message;
    }

    public LoginUserResponse() {
    }

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

