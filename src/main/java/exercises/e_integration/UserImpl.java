package exercises.e_integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserImpl implements User {

    private String name;

    private Set<Category> categories;

    public UserImpl(String name) {
        this.setName(name);
        this.categories = new HashSet<Category>();
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(this.categories);
    }

    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can`t be null!");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        if (this.categories.contains(category)) {
            this.categories.remove(category);
        }
    }
}