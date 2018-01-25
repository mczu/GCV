package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private UserId id;
    private String login;
    private String password;
    private String email;
    private LocalDateTime createDate;
}
