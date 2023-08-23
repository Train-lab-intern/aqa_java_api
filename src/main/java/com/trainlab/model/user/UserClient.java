package com.trainlab.model.user;

import com.trainlab.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    private static final String PATH_REGISTER = "/api/v1/users/register";
    private static final String LOGIN_REGISTER = "/api/v1/auth";

    public static ValidatableResponse createUser (User user) {

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
                .post(LOGIN_REGISTER)
                .then();

    }

}