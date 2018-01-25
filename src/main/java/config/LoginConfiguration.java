package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.UserRepository;
import web.LoginUserRestController;

@Configuration
public class LoginConfiguration {

    @Bean
    public LoginUserRestController loginUserRestController(
            UserRepository userRepository
    ) {
        return new LoginUserRestController(userRepository);
    }
}
