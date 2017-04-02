package exercises.e_integration;

import java.util.Set;

public interface Category {

    void addUser(User user);

    Set<User> getUsers();

    String getName();
}