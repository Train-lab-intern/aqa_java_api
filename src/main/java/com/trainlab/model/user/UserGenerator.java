package com.trainlab.model.user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

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