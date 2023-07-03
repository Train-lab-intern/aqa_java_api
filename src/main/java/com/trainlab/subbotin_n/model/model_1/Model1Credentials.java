package com.trainlab.subbotin_n.model.model_1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model1Credentials {

    private String email;
    private String password;
    private String name;

    public static Model1Credentials from(Model1 user) {
        return new Model1Credentials(user.getEmail(), user.getPassword(), user.getName());
    }

}