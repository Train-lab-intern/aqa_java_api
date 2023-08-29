package com.trainlab;

import com.trainlab.model.user.User;
import com.trainlab.model.user.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.trainlab.model.user.UserClient.*;
import static com.trainlab.model.user.UserCredentials.from;
import static com.trainlab.model.user.UserGenerator.getUser;
import static com.trainlab.model.user.UserType.VALID_USER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginUserTest {

    private UserClient userClient;
    private User user;
    private ValidatableResponse response;

    @Before
    public void setUp() {

        userClient = new UserClient();
        user = getUser(VALID_USER);

        createUser(user);
        completeRegistration(user.getEmail());

    }

    @Test
    @DisplayName("Success login User")
    @Description("Expected response: StatusCode 200")
    public void a_succesLoginUserTest() {

        response = loginUser(from(user));

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_OK, actualStatusCode);

    }

}