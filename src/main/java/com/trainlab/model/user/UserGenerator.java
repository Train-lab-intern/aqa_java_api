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
                createNoNameUser();
                break;
            case NO_EMAIL_USER:
                createNoEmailUser();
                break;
            case NO_PASSWORD_USER:
                createNoPasswordUser();
                break;
            case INVALID_PASSWORD_USER:
                createInvalidPasswordUser();
                break;
        }
        return user;
    }

    private static void createValidUser() {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword(getRandomValidPassword());
    }

    private static void createNoNameUser() {
        user.setUsername("");
        user.setEmail(getRandomEmail());
        user.setPassword(getRandomValidPassword());
    }

    private static void createNoEmailUser() {
        user.setUsername(getRandomUserName());
        user.setEmail("");
        user.setPassword(getRandomValidPassword());
    }

    private static void createNoPasswordUser() {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword("");
    }

    private static void createInvalidPasswordUser() {
        user.setUsername(getRandomUserName());
        user.setEmail(getEmailWithLocalPart(user.getUsername()));
        user.setPassword(getRandomInvalidPassword());
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

    private static String getRandomInvalidPassword() {
        return faker.internet().password(3, 4, false, false, false) + "A0";
    }

}