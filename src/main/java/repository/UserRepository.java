package repository;

import model.User;
import model.UserId;

import java.util.Optional;

public interface UserRepository {

    void create(User user);

    void delete(UserId userId);

    Optional<User> findByLogin(String login);

}
