package site.nomoreparties.stellarburgers.model;

public class DeleteUserResponse {
    private Boolean success;
    private String message;


    public DeleteUserResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public DeleteUserResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
