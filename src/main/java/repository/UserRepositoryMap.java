package repository;

import model.User;
import model.UserId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public Optional<User> findByLogin(String login) {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }
}
