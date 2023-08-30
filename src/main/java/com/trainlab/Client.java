package com.trainlab;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Client {

    private static final String BASE_URL = "https://test.app.it-roast.com";

    protected static RequestSpecification getSpec() {

        RestAssured.filters(new ResponseLoggingFilter());

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}