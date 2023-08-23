package com.trainlab;

import com.trainlab.model.user.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.trainlab.model.user.UserClient.createUser;
import static com.trainlab.model.user.UserGenerator.getUser;
import static com.trainlab.model.user.UserType.VALID_USER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateUserTest {

    private UserClient userClient;
    private ValidatableResponse response;

    @Before
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Success create User")
    @Description("Expected response: StatusCode 200")
    public void a_succesCreateUserTest() {

        response = createUser(getUser(VALID_USER));

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_OK, actualStatusCode);

    }

}