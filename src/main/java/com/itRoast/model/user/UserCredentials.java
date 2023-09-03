package com.itRoast.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.itRoast.model.user.UserGenerator.getRandomEmail;
import static com.itRoast.model.user.UserGenerator.getRandomValidPassword;

@Setter
@Getter
@AllArgsConstructor
public class UserCredentials {

    private String userEmail;
    private String userPassword;

    public static UserCredentials from(User user) {
        return new UserCredentials(user.getEmail(), user.getPassword());
    }

    public static UserCredentials replaceUserEmail(User user) {
        user.setEmail(getRandomEmail());
        return new UserCredentials(user.getEmail(), user.getPassword());
    }

    public static UserCredentials replaceUserPassword(User user) {
        user.setPassword(getRandomValidPassword());
        return new UserCredentials(user.getEmail(), user.getPassword());
    }

}