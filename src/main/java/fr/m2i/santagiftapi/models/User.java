package fr.m2i.santagiftapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
abstract class User {

    private String username;
    private String password;
    private String avatar;


}
