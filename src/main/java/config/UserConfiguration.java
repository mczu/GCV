package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.ResumeRepository;
import repository.UserRepository;
import repository.UserRepositoryMap;
import web.*;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryMap();
    }

    @Bean
    public DeleteUserRestController deleteUsereRestController(
            UserRepository userRepository
    ) {
        return new DeleteUserRestController(userRepository);
    }

    @Bean
    public RegisterUserRestController registerUserRestController(
            UserRepository userRepository
    ) {
        return new RegisterUserRestController(userRepository);
    }

}
