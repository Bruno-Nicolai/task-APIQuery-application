package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.User;

public class UserRepository {

    private Map<Integer, User> usersMap;

    private static UserRepository instance = null;

    private UserRepository() {
        this.usersMap = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        if (user != null) {
            this.usersMap.put(user.getId(), user);
        }
    }

    public boolean contains(User user) {
        return this.usersMap.containsValue(user);
    }

    public boolean contains(Integer id) {
        return this.usersMap.containsKey(id);
    }

    public Collection<User> getUsers() {
        return this.usersMap.values();
    }

    public User getUser(int id) {
        return this.usersMap.get(id);
    }

}
