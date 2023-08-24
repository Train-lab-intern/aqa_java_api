package com.trainlab.model.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {

    private static final Faker faker = new Faker(new Locale("en"));
    private static final User user = new User();

    public static User getUser(UserType userType) {

        switch (userType) {
            case VALID_USER:
                createValidUser();
                break;
            case NO_NAME_USER:
                createUserNoName();
                break;
            case NO_EMAIL_USER:
                createUserNoEmail();
                break;
            case NO_PASSWORD_USER:
                createUserNoPassword();
                break;
        }
        return user;
    }

    public static User getUserWithInvalidPassword(int minimumLength, int maximumLength) {

        createUserWithInvalidPassword(minimumLength, maximumLength);

        return user;
    }

    private static void createValidUser() {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword(getRandomValidPassword());
    }

    private static void createUserNoName() {
        user.setUsername("");
        user.setEmail(getRandomEmail());
        user.setPassword(getRandomValidPassword());
    }

    private static void createUserNoEmail() {
        user.setUsername(getRandomUserName());
        user.setEmail("");
        user.setPassword(getRandomValidPassword());
    }

    private static void createUserNoPassword() {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword("");
    }

    private static void createUserWithInvalidPassword(int minimumLength, int maximumLength) {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword(getRandomInvalidPassword(minimumLength, maximumLength));
    }

    private static String getRandomUserName() {
        return faker.name().firstName();
    }

    private static String getRandomEmail() {
        return faker.internet().emailAddress(getRandomUserName());
    }

    private static String getEmailWithLocalPart(String localPart) {
        return faker.internet().emailAddress(localPart);
    }

    private static String getRandomValidPassword() {
        return faker.internet().password(8, 10, false, false, false) + "A0";
    }

    private static String getRandomInvalidPassword(int minimumLength, int maximumLength) {
        return faker.internet().password(minimumLength, maximumLength, false, false, false) + "A0";
    }

}