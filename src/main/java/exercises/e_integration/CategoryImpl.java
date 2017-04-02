package exercises.e_integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CategoryImpl implements Category {

    private String name;

    private Set<User> users;

    public CategoryImpl(String name) {
        this.setName(name);
        this.setUsers();
    }

    private void setUsers() {
        this.users = new HashSet<User>();
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(this.users);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can`t be null!");
        }
        this.name = name;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}