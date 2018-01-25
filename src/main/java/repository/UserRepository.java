package repository;

import model.User;
import model.UserId;

public interface UserRepository {

    void create(User user);

    void delete(UserId userId);

}
