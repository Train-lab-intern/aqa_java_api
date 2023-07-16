package com.trainlab.subbotin_n;

import com.trainlab.subbotin_n.model.home_page.HomePageClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class GetDataHomePageTest {
    private ValidatableResponse response;

    @Test
    @DisplayName("Get Data from Home Page")
    @Description("Expected response: StatusCode 200")
    public void a_getDataHomePageTest() {

        response = HomePageClient.getDataHomePage();

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_OK, actualStatusCode);
    }
}
