package com.trainlab.model.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {

    private static final Faker faker = new Faker(new Locale("en"));
    private static final User user = new User();

    public static User getUser(UserType userType) {

        switch (userType) {
            case VALID_USER:
                user.setUsername(getRandomUserName());
                user.setEmail(getEmailWithLocalPart(user.getUsername()));
                user.setPassword(getRandomValidPassword());
                break;
            case NO_NAME_USER:
                user.setUsername("");
                user.setEmail(getRandomEmail());
                user.setPassword(getRandomValidPassword());
                break;
            case NO_EMAIL_USER:
                user.setUsername(getRandomUserName());
                user.setEmail("");
                user.setPassword(getRandomValidPassword());
                break;
            case NO_PASSWORD_USER:
                user.setUsername(getRandomUserName());
                user.setEmail(getEmailWithLocalPart(user.getUsername()));
                user.setPassword("");
                break;
        }
        return user;
    }

    public static String getRandomUserName() {
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

    public static String getRandomInvalidPassword() {
        return faker.internet().password(3, 4, false, false, false) + "A0";
    }

}