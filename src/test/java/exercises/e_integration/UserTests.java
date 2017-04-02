package exercises.e_integration;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class UserTests {

    private static final String USERNAME = "Niki";
    private static final String CATEGORY_NAME = "My Category";
    private static final String CATEGORY_NAME_2 = "Category 2";
    private static final String CATEGORY_NAME_3 = "Category 3";
    private static final int EXPECTED_CATEGORIES_COLLECTION_SIZE = 1;

    @Test
    public void createUser() {
        // Act
        User user = new UserImpl(USERNAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createUserWithNullName() {
        // Act
        User user = new UserImpl(null);
    }

    @Test
    public void addCategoryToUser() {
        // Arrange
        User user = new UserImpl(USERNAME);
        Category category = new CategoryImpl(CATEGORY_NAME);
        // Act
        user.addCategory(category);
        String categoryNameExpected = user.getCategories().iterator().next().getName();
        // Assert
        Assert.assertEquals("Expected category name to be the same", CATEGORY_NAME, categoryNameExpected);
    }

    @Test
    public void addMultipleCategoriesToUser() {
        // Arrange
        User user = new UserImpl(USERNAME);
        Category category1 = new CategoryImpl(CATEGORY_NAME);
        Category category2 = new CategoryImpl(CATEGORY_NAME_2);
        Category category3 = new CategoryImpl(CATEGORY_NAME_3);
        // Act
        user.addCategory(category1);
        user.addCategory(category2);
        user.addCategory(category3);
        Set<Category> categories = user.getCategories();
        // Assert
        Assert.assertEquals("Expected to contain category1", true, categories.contains(category1));
        Assert.assertEquals("Expected to contain category2", true, categories.contains(category2));
        Assert.assertEquals("Expected to contain category3", true, categories.contains(category3));
    }

    @Test
    public void addMultipleTimesOneCategoryToUser() {
        // Arrange
        User user = new UserImpl(USERNAME);
        Category category = new CategoryImpl(CATEGORY_NAME);
        // Act
        user.addCategory(category);
        user.addCategory(category);
        Set<Category> categories = user.getCategories();
        // Assert
        Assert.assertEquals("Expected categories size to be 1", EXPECTED_CATEGORIES_COLLECTION_SIZE, categories.size());
    }
}