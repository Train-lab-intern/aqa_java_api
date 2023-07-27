package com.trainlab.model.home_page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trainlab.Client;
import io.restassured.response.ValidatableResponse;

import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

public class HomePageClient extends Client {

    protected static Gson gson;
    protected static TypeToken<Map<String, String>> mapType;
    protected static ValidatableResponse response;

    private static final String PATH_GET_DATA = "/front/pages/1";

    public static ValidatableResponse getData() {
        return given()
                .spec(getSpec())
                .get(PATH_GET_DATA)
                .then();
    }

    public static Map<String, String> getDataHomePage() {
        gson = new Gson();
        mapType = new TypeToken<>(){};

        response = HomePageClient.getData();
        String json = response.extract().asString();

        Map<String, String> stringMap = gson.fromJson(json, mapType);
        stringMap = sortByKeys(stringMap);

        return stringMap;
    }

    private static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap)
    {
        return new TreeMap<>(unsortedMap);
    }
}