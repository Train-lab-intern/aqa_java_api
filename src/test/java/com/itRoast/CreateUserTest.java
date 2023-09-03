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

import static com.itRoast.model.user.UserClient.createUser;
import static com.itRoast.model.user.UserGenerator.getUser;
import static com.itRoast.model.user.UserGenerator.getUserWithInvalidPassword;
import static com.itRoast.model.user.UserType.*;
import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateUserTest {

    private UserClient userClient;
    private ValidatableResponse response;

    private static final String USERNAME_IS_ALREADY_EXISTS = "User with this username is already exists.";
    private static final String USERNAME_MUST_NOT_BE_NULL = "User name must not be null";
    private static final String EMAIL_MUST_BE_BETWEEN_8_AND_256_CHARACTERS = "User email must be between 8 and 256 characters";
    private static final String EMAIL_MUST_NOT_BE_NULL = "User email must not be null";
    private static final String CONTAIN_8_CHARACTERS_AND_AT_LEAST_ONE_LOWERCASE_AND_ONE_UPPERCASE_CHARACTER = "Password must contain 8 characters and at least one lowercase and one uppercase character";
    private static final String PASSWORD_MUST_NOT_BE_NULL = "User password must not be null";
    private static final String MUST_BE_BETWEEN_8_AND_256_CHARACTERS = "User password must be between 8 and 256 characters";

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
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(USERNAME_IS_ALREADY_EXISTS, actualMessage);

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
    @DisplayName("Create User with is null name")
    @Description("Expected response: StatusCode 400")
    public void d_createUserNameIsNullTest() {
        response = createUser(getUser(NAME_IS_NULL_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(USERNAME_MUST_NOT_BE_NULL, actualMessage);

    }

    @Test
    @DisplayName("Create User no email")
    @Description("Expected response: StatusCode 400")
    public void e_createUserNoEmailTest() {
        response = createUser(getUser(NO_EMAIL_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(EMAIL_MUST_BE_BETWEEN_8_AND_256_CHARACTERS, actualMessage);

    }

    @Test
    @DisplayName("Create User with is null email")
    @Description("Expected response: StatusCode 400")
    public void f_createUserEmailIsNullTest() {
        response = createUser(getUser(EMAIL_IS_NULL_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(EMAIL_MUST_NOT_BE_NULL, actualMessage);

    }

    @Test
    @DisplayName("Create User no password")
    @Description("Expected response: StatusCode 400")
    public void g_createUserNoPasswordTest() {
        response = createUser(getUser(NO_PASSWORD_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(CONTAIN_8_CHARACTERS_AND_AT_LEAST_ONE_LOWERCASE_AND_ONE_UPPERCASE_CHARACTER, actualMessage);

    }

    @Test
    @DisplayName("Create User with is null password")
    @Description("Expected response: StatusCode 400")
    public void h_createUserPasswordIsNullTest() {
        response = createUser(getUser(PASSWORD_IS_NULL_USER));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(PASSWORD_MUST_NOT_BE_NULL, actualMessage);

    }

    @Test
    @DisplayName("Create user with small password")
    @Description("Expected response: StatusCode 400")
    public void i_createUserWithInvalidPasswordTest() {
        response = createUser(getUserWithInvalidPassword(4, 5));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(MUST_BE_BETWEEN_8_AND_256_CHARACTERS, actualMessage);

    }

    @Test
    @DisplayName("Create user with big password")
    @Description("Expected response: StatusCode 400")
    public void j_createUserWithInvalidPasswordTest() {
        response = createUser(getUserWithInvalidPassword(255, 256));

        int actualStatusCode = response.extract().statusCode();
        String actualMessage = response.extract().path("message");

        assertEquals(SC_BAD_REQUEST, actualStatusCode);
        assertEquals(MUST_BE_BETWEEN_8_AND_256_CHARACTERS, actualMessage);

    }

}