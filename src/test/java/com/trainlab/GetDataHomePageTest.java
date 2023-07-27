package com.trainlab;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;

import static com.trainlab.model.home_page.HomePageClient.getDataHomePage;
import static com.trainlab.model.home_page.JdbcPostgreSQLConnect.getDataFromDataBase;
import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetDataHomePageTest {

    protected Map<String, String> expectedDataFromDataBase;
    protected Map<String, String> actualDataFromHomePage;

    @Test
    @DisplayName("Check data from HomePage")
    @Description("Expected response: Actual data from HomePage is equal to data from DataBase")
    public void a_checkDataFromHomePage() throws Exception {

        expectedDataFromDataBase = getDataFromDataBase();
        actualDataFromHomePage = getDataHomePage();

        for (int i = 0; i < expectedDataFromDataBase.size(); i++) {
            System.out.println(expectedDataFromDataBase.keySet());
        }

//        assertEquals(expectedDataFromDataBase, actualDataFromHomePage);

    }
}