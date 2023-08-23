package com.trainlab.model.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {

    private static final Faker faker = new Faker(new Locale("en"));
    private static final User user = new User();

    public static User getUser(UserType userType) {

        switch (userType) {
            case VALID_USER:
                user.setUsername(faker.name().firstName());
                user.setEmail(faker.internet().emailAddress());
                user.setPassword(faker.internet().password(8, 10, true, false, true));
                break;
            case NO_NAME_USER:
                user.setEmail(faker.internet().emailAddress());
                user.setPassword(faker.internet().password(8, 10, true, false, true));
                break;
            case NO_EMAIL_USER:
                user.setUsername(faker.name().firstName());
                user.setPassword(faker.internet().password(8, 10, true, false, true));
                break;
            case NO_PASSWORD_USER:
                user.setUsername(faker.name().firstName());
                break;
        }
        return user;
    }

    public static String getRandomUserName() {
        return faker.name().firstName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 10, true, false, true);
    }

}