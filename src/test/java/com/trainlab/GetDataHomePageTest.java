package com.trainlab;

import com.trainlab.model.home_page.DataHomePage;
import com.trainlab.model.home_page.HomePageClient;
import com.trainlab.model.home_page.JdbcPostgreSQLConnect;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetDataHomePageTest {

    protected ValidatableResponse response;
    protected DataHomePage actualDataHomePage;

    @Before
    public void setUp() throws Exception {
        JdbcPostgreSQLConnect.getDataFromHomePage();

        response = HomePageClient.getDataHomePage();
        actualDataHomePage = response.extract().as(DataHomePage.class);
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.1")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void a_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.1), actualDataHomePage.getOne());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.2")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void b_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.2), actualDataHomePage.getTwo());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.3")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void c_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.3), actualDataHomePage.getThree());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.4")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void d_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.4), actualDataHomePage.getFour());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.5")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void e_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.5), actualDataHomePage.getFive());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.6")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void f_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.6), actualDataHomePage.getSix());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.7")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void g_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.7), actualDataHomePage.getSeven());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.8")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void h_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.8), actualDataHomePage.getEight());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.9")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void i_checkDataFromHomePage() {
        assertEquals(JdbcPostgreSQLConnect.expectedDataFromDb.get(1.9), actualDataHomePage.getNine());
    }

    @After
    public void tearDown() throws SQLException {
        JdbcPostgreSQLConnect.closeConnect();
    }
}