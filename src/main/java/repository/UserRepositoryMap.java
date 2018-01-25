package repository;

import model.User;
import model.UserId;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryMap implements UserRepository {
    private static Map<UserId, User> users = new HashMap<>();

    @Override
    public void create(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(UserId userId) {
        users.remove(userId);
    }
}
