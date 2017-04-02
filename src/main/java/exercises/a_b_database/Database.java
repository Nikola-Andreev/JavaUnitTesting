package exercises.a_b_database;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Long, Human> persons;

    public Database() {
        this.setElements();
    }

    public Map<Long, Human> getElements() {
        return Collections.unmodifiableMap(this.persons);
    }

    private void setElements() {
        this.persons = new HashMap<Long, Human>();
    }

    public void add (Human person) throws OperationNotSupportedException {
        if (this.persons.containsKey(person.getId())) {
            throw new OperationNotSupportedException("Person wit that ID already exists!");
        } else if (person.getId() == null || person.getId() < 0) {
            throw new OperationNotSupportedException("ID can not be negative or null!");
        }
        this.persons.put(person.getId(), person);
    }

    public void remove (Long id) {
        this.persons.remove(id);
    }

    public Human findByUsername(String username) throws OperationNotSupportedException {
        // check username for null
        if (username == null) {
            throw new OperationNotSupportedException("Username cannot be null!");
        }

        // iterate over all users
        for (Human human : persons.values()) {
            if (human.getUsername().equals(username)) {
                return  human;
            }
        }

        // throw exception if user with that name is not found
        throw new OperationNotSupportedException("User with that name not exists in database!");
    }

    public Human findById (Long id) throws OperationNotSupportedException {
        // check username for null
        if (id == null) {
            throw new OperationNotSupportedException("Id cannot be null!");
        }

        // iterate over all users
        for (Human human : persons.values()) {
            if (human.getId().equals(id)) {
                return  human;
            }
        }

        // throw exception if user with that id is not found
        throw new OperationNotSupportedException("User with that name not exists in database!");
    }
}