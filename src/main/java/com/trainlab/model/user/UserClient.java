package com.trainlab.model.user;

import com.trainlab.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    private static final String PATH_REGISTER = "/api/v1/users/register";
    private static final String PATH_LOGIN_REGISTER = "/api/v1/auth";
    private static final String PATH_COMPLETE_REGISTER = "/api/v1/users/complete-registration";

    public static ValidatableResponse createUser(User user) {

        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH_REGISTER)
                .then();

    }

    public static ValidatableResponse loginUser(UserCredentials credentials) {

        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(PATH_LOGIN_REGISTER)
                .then();

    }

    public static ValidatableResponse completeRegistration(String email) {
        return given()
                .spec(getSpec())
                .get(String.format(PATH_COMPLETE_REGISTER + "?userEmail=%s", email))
                .then();
    }

}