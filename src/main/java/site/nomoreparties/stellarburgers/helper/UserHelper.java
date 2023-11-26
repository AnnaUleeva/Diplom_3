package site.nomoreparties.stellarburgers.helper;

import site.nomoreparties.stellarburgers.client.UserApiClient;
import site.nomoreparties.stellarburgers.model.*;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserHelper {
    UserApiClient userApiClient;
    String email;
    String password;
    String name;
    String accessToken;

    public UserHelper() {
        userApiClient = new UserApiClient();
        RegisterUserRequest randomUser = UserGenerator.getRandomUser();
        email = randomUser.getEmail();
        password = randomUser.getPassword();
        name = randomUser.getName();
    }

    public void create() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(email, password, name);
        RegisterUserResponse registerUserResponse = userApiClient.registerUser(registerUserRequest).then().statusCode(SC_OK).and().extract().as(RegisterUserResponse.class);
        accessToken = registerUserResponse.getAccessToken();
    }

    public void login() {
        LoginUserRequest loginUserRequest = new LoginUserRequest(email, password);
        LoginUserResponse loginUserResponse = userApiClient.loginUser(loginUserRequest).then().statusCode(SC_OK).and().extract().as(LoginUserResponse.class);
        accessToken = loginUserResponse.getAccessToken();
    }

    public void delete() {
        userApiClient.deleteUser(accessToken).then().statusCode(SC_ACCEPTED).and().extract().as(DeleteUserResponse.class);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
