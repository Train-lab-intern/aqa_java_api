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

import static com.trainlab.model.user.UserClient.createUser;
import static com.trainlab.model.user.UserGenerator.getUser;
import static com.trainlab.model.user.UserType.*;
import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateUserTest {

    private UserClient userClient;
    private ValidatableResponse response;

    private static final String EMAIL_MUST_NOT_BE_NULL = "User email must not be null";
    private static final String PASSWORD_MUST_NOT_BE_NULL = "User password must not be null";

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

    @Test
    @DisplayName("Create duplicate User")
    @Description("Expected response: StatusCode 400")
    public void b_createDuplicateUserTest() {
        User user = getUser(VALID_USER);
        response = createUser(user);

        response = createUser(user);

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_BAD_REQUEST, actualStatusCode);

    }

    @Test
    @DisplayName("Create User no name")
    @Description("Expected response: StatusCode 400")
    public void c_createUserNoNameTest() {
        response = createUser(getUser(NO_NAME_USER));

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_BAD_REQUEST, actualStatusCode);

    }

    @Test
    @DisplayName("Create User no email")
    @Description("Expected response: StatusCode 400")
    public void d_createUserNoEmailTest() {
        response = createUser(getUser(NO_EMAIL_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(EMAIL_MUST_NOT_BE_NULL, actualMessage);

    }

    @Test
    @DisplayName("Create User no password")
    @Description("Expected response: StatusCode 400")
    public void e_createUserNoPasswordTest() {
        response = createUser(getUser(NO_PASSWORD_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(PASSWORD_MUST_NOT_BE_NULL, actualMessage);

    }

}