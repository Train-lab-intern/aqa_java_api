package com.trainlab.tursunbekova_a.model.model_2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model2Credentials {

    private String email;
    private String password;
    private String name;

    public static Model2Credentials from(Model2 user) {
        return new Model2Credentials(user.getEmail(), user.getPassword(), user.getName());
    }

}