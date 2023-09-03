package com.itRoast.model.home_page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itRoast.Client;
import io.restassured.response.ValidatableResponse;

import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

public class HomePageClient extends Client {

    protected static Gson gson;
    protected static TypeToken<Map<String, String>> mapType;
    protected static ValidatableResponse response;

    private static final String PATH_GET_DATA = "/front/pages/1";

    public static Map<String, String> getDataHomePage() {
        gson = new Gson();
        mapType = new TypeToken<>(){};

        String json = response.extract().asString();

        Map<String, String> stringMap = gson.fromJson(json, mapType);
        stringMap = sortByKeys(stringMap);

        return stringMap;
    }

    public static int getStatusCode() {
        return response.extract().statusCode();
    }

    public static void sendGetRequest() {
        response = given()
                .spec(getSpec())
                .get(PATH_GET_DATA)
                .then();
    }

    private static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap)
    {
        return new TreeMap<>(unsortedMap);
    }
}