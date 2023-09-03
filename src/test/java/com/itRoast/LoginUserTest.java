package com.itRoast;

import com.itRoast.model.user.User;
import com.itRoast.model.user.UserClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.itRoast.model.user.UserClient.*;
import static com.itRoast.model.user.UserCredentials.*;
import static com.itRoast.model.user.UserGenerator.getUser;
import static com.itRoast.model.user.UserType.VALID_USER;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginUserTest {

    public static final String BAD_CREDENTIALS = "Bad credentials";
    private UserClient userClient;
    private User user;
    private ValidatableResponse response;

    private static final String NOT_FOUND_WITH_EMAIL = "User not found with email";

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
        String actualToken = response.extract().path("token");

        assertEquals(SC_OK, actualStatusCode);
        assertNotNull(actualToken);

    }

    @Test
    @DisplayName("Login user with invalid email")
    @Description("Expected response: StatusCode 400")
    public void b_loginUserInvalidEmailTest() {
        response = loginUser(replaceUserEmail(user));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(String.format(NOT_FOUND_WITH_EMAIL + ": %s", user.getEmail()), actualMessage);

    }

    @Test
    @DisplayName("Login user with invalid password")
    @Description("Expected response: StatusCode 400")
    public void c_loginUserNotValidPasswordTest() {
        response = loginUser(replaceUserPassword(user));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(BAD_CREDENTIALS, actualMessage);

    }

}