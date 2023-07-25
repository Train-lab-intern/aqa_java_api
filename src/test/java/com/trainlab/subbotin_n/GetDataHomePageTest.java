package com.trainlab.subbotin_n;

import com.trainlab.subbotin_n.model.home_page.DataHomePage;
import com.trainlab.subbotin_n.model.home_page.HomePageClient;
import com.trainlab.subbotin_n.model.home_page.JdbcPostgreSQLConnect;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.*;

import static com.trainlab.subbotin_n.model.home_page.JdbcPostgreSQLConnect.closeConnect;
import static com.trainlab.subbotin_n.model.home_page.JdbcPostgreSQLConnect.connection;
import static org.junit.Assert.*;

public class GetDataHomePageTest {

    private ValidatableResponse response;
    private Statement statement;
    private final Map<Double, String> expectedDataFromDb = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        JdbcPostgreSQLConnect.connectDataBase();
        statement = connection.createStatement();
    }

    @Test
    @DisplayName("Check data from HomePage")
    @Description("Expected response: StatusCode 200 and Actual Data from HomePage")
    public void a_checkDataFromHomePage() throws Exception {

        ResultSet resultSet = statement.executeQuery("SELECT front_id, text FROM frontend_data WHERE id = 1");

        while (resultSet.next()) {
            expectedDataFromDb.put(resultSet.getDouble("front_id"), resultSet.getString("text"));
        }

        response = HomePageClient.getDataHomePage();
        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        assertEquals(expectedDataFromDb.get(1.1), actualDataHomePage.getOne());
    }

    @After
    public void tearDown() throws SQLException {
        closeConnect();
    }
}