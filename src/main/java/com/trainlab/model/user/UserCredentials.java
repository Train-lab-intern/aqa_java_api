package com.trainlab.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserCredentials {

    private String username;
    private String email;
    private String password;

    public static UserCredentials from(User user) {
        return new UserCredentials(null, user.getEmail(), user.getPassword());
    }

}