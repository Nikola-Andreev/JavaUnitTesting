package exercises.e_integration;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class CategoryTests {

    private static final String USERNAME = "Niki";
    private static final String CATEGORY_NAME = "My category";
    private static final String USERNAME2 = "Poli";
    private static final String USERNAME3 = "Gonzi";
    private static final int EXPECTED_USERS_COLLECTION_SIZE = 1;

    @Test
    public void createCategory() {
        // Act
        Category category = new CategoryImpl(CATEGORY_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createCategoryWithNull() {
        // Act
        Category category = new CategoryImpl(null);
    }

    @Test
    public void addUserToCategory() {
        // Arrange
        Category category = new CategoryImpl(CATEGORY_NAME);
        User user = new UserImpl(USERNAME);
        // Act
        category.addUser(user);
        String userNameExpected = category.getUsers().iterator().next().getName();
        // Assert
        Assert.assertEquals("Expected username to be the same", USERNAME, userNameExpected);
    }

    @Test
    public void addMultipleUsersToCategory() {
        // Arrange
        Category category = new CategoryImpl(CATEGORY_NAME);
        User user1 = new UserImpl(USERNAME);
        User user2 = new UserImpl(USERNAME2);
        User user3 = new UserImpl(USERNAME3);
        // Act
        category.addUser(user1);
        category.addUser(user2);
        category.addUser(user3);
        Set<User> users = category.getUsers();
        // Assert
        Assert.assertEquals("Expected to contain user1", true, users.contains(user1));
        Assert.assertEquals("Expected to contain user2", true, users.contains(user1));
        Assert.assertEquals("Expected to contain user3", true, users.contains(user1));
    }

    @Test
    public void addMultipleTimesOneUserToCategory() {
        // Arrange
        Category category = new CategoryImpl(CATEGORY_NAME);
        User user1 = new UserImpl(USERNAME);
        // Act
        category.addUser(user1);
        category.addUser(user1);
        Set<User> users = category.getUsers();
        // Assert
        Assert.assertEquals("Expected users size to be 1", EXPECTED_USERS_COLLECTION_SIZE, users.size());
    }
}