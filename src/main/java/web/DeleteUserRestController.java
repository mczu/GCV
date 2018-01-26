package web;

import lombok.AllArgsConstructor;
import model.RegisterUser;
import model.User;
import model.UserId;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class DeleteUserRestController {
    private final UserRepository userRepository;

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId) {
        UserId userId1 = new UserId(userId);
        userRepository.delete(userId1);
    }
}
