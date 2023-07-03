package com.trainlab.tursunbekova_a.model.model_1;

import com.trainlab.subbotin_n.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Model1Client extends Client {

    private static final String PATH_REGISTER = "...";
    private static final String PATH_LOGIN = "...";

    public static ValidatableResponse createUser(Model1 user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH_REGISTER)
                .then();
    }

    public static ValidatableResponse loginUser(Model1Credentials credentials) {
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

}