package com.trainlab.subbotin_n;

import com.trainlab.subbotin_n.model.home_page.DataHomePage;
import com.trainlab.subbotin_n.model.home_page.HomePageClient;
import com.trainlab.subbotin_n.model.home_page.JdbcPostgreSQLConnect;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.*;
import java.util.*;

import static com.trainlab.subbotin_n.model.home_page.JdbcPostgreSQLConnect.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetDataHomePageTest {

    private ValidatableResponse response;
    public static Statement statement;
    public static final Map<Double, String> expectedDataFromDb = new HashMap<>();


    @Before
    public void setUp() throws Exception {
        JdbcPostgreSQLConnect.connectDataBase();
        statement = connection.createStatement();
        getDataFromHomePage();
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.1")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void a_checkDataFromHomePage() {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.1), actualDataHomePage.getOne());

    }

    private static void getDataFromHomePage() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT front_id, text FROM frontend_data");

        while (resultSet.next()) {
            expectedDataFromDb.put(resultSet.getDouble("front_id"), resultSet.getString("text"));
        }
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.2")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void b_checkDataFromHomePage() {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.2), actualDataHomePage.getTwo());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.3")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void c_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.3), actualDataHomePage.getThree());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.4")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void d_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.4), actualDataHomePage.getFour());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.5")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void e_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.5), actualDataHomePage.getFive());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.6")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void f_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.6), actualDataHomePage.getSix());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.7")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void g_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.7), actualDataHomePage.getSeven());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.8")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void h_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.8), actualDataHomePage.getEight());
    }

    @Test
    @DisplayName("Check data from HomePage with id 1.9")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void i_checkDataFromHomePage() throws Exception {

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.9), actualDataHomePage.getNine());
    }

    @After
    public void tearDown() throws SQLException {
        closeConnect();
    }
}