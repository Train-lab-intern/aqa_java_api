package com.trainlab.subbotin_n.model.home_page;

import com.trainlab.subbotin_n.Client;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class HomePageClient extends Client {

    private static final String PATH_GET_DATA = "/front/pages/1";

    public static ValidatableResponse getDataHomePage() {
        return given()
                .spec(getSpec())
                .get(PATH_GET_DATA)
                .then();
    }

}