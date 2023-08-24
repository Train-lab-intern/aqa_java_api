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
                user.setUsername(null);
                user.setEmail(getRandomEmail());
                user.setPassword(getRandomValidPassword());
                break;
            case NO_EMAIL_USER:
                user.setUsername(getRandomUserName());
                user.setEmail(null);
                user.setPassword(getRandomValidPassword());
                break;
            case NO_PASSWORD_USER:
                user.setUsername(getRandomUserName());
                user.setEmail(getEmailWithLocalPart(user.getUsername()));
                user.setPassword(null);
                break;
        }
        return user;
    }

    public static String getRandomUserName() {
        return faker.name().firstName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress(getRandomUserName());
    }

    public static String getEmailWithLocalPart(String localPart) {
        return faker.internet().emailAddress(localPart);
    }

    public static String getRandomValidPassword() {
        return faker.internet().password(8, 10, true, false, true);
    }

}