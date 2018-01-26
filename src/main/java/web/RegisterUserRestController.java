package web;

import lombok.AllArgsConstructor;
import model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ResumeRepository;
import repository.UserRepository;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class RegisterUserRestController {
    private final UserRepository userRepository;

    @PostMapping("/users")
    public void createUser(@RequestBody RegisterUser registerUser) {
        User user = new User();
        user.setId(new UserId());
        user.setLogin(registerUser.getLogin());
        user.setPassword(registerUser.getPassword()); // TODO: hash it
        user.setEmail(registerUser.getEmail());
        user.setCreateDate(LocalDateTime.now());

        userRepository.create(user);
    }
}
