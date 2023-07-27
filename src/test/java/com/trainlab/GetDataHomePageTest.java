package com.trainlab;

import com.trainlab.model.home_page.HomePageClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.Map;

import static com.trainlab.model.home_page.HomePageClient.getDataHomePage;
import static com.trainlab.model.home_page.JdbcPostgreSQLConnect.getDataFromDataBase;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;


public class GetDataHomePageTest {

    protected Map<String, String> expectedDataFromDataBase;
    protected Map<String, String> actualDataFromHomePage;

    @Test
    @DisplayName("Check data from HomePage")
    @Description("Expected response: Actual data from HomePage is equal to data from DataBase")
    public void checkDataFromHomePage() throws Exception {
        HomePageClient.sendGetRequest();

        assertEquals(SC_OK, HomePageClient.getStatusCode());

        expectedDataFromDataBase = getDataFromDataBase();
        actualDataFromHomePage = getDataHomePage();

        assertEquals(expectedDataFromDataBase, actualDataFromHomePage);

    }
}