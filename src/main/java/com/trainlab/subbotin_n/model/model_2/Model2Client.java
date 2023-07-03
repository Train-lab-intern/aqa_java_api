package com.trainlab.subbotin_n.model.model_2;

import com.trainlab.subbotin_n.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Model2Client extends Client {

    private static final String PATH_REGISTER = "...";
    private static final String PATH_LOGIN = "...";

    public static ValidatableResponse createUser(Model2 user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH_REGISTER)
                .then();
    }

    public static ValidatableResponse loginUser(Model2Credentials credentials) {
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

}