package web;

import lombok.AllArgsConstructor;
import model.LoginUser;
import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class LoginUserRestController {
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser) {
        Optional<User> userOptional = userRepository.findByLogin(loginUser.getLogin());

        if (!userOptional.isPresent()) {
            return new ResponseEntity("BAD_CREDENTIALS", HttpStatus.BAD_REQUEST);
        }

        if (!userOptional.get().getPassword().equals(loginUser.getPassword())) {
            return new ResponseEntity("BAD_CREDENTIALS", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(userOptional.get().getId().getValue(), HttpStatus.OK);
    }
}
