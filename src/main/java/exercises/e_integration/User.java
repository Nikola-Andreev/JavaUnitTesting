package exercises.e_integration;

import java.util.Set;

public interface User {

    void addCategory(Category category);

    void removeCategory(Category category);

    String getName();

    public Set<Category> getCategories();
}
