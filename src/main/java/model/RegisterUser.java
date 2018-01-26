package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {

    private String login;
    private String password;
    private String email;
}
