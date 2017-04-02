package exercises.a_b_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseAddTests {


    private static final int ACTUAL_DB_SIZE_EXPECTED = 1;
    private static final String EXPECTED_HUMAN_USERNAME = "Miki Mouse";
    private Database db;

    @Before
    public void createDatabase() {
        // Arrange
        db = new Database();
    }

    @Test
    public void addPerson() throws OperationNotSupportedException {
        // Act
        db.add(new Person(Long.parseLong("44"),"Miki Mouse"));
        int size = db.getElements().size();
        String username = db.getElements().get((long)44).getUsername();
        // Assert
        Assert.assertEquals("Database elements count to be one", ACTUAL_DB_SIZE_EXPECTED, size);
        Assert.assertEquals("First element name to be Miki Mouse", EXPECTED_HUMAN_USERNAME, username);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addTwoPersonsWithSameId() throws OperationNotSupportedException {
        // Act
        db.add(new Person(Long.parseLong("44"),"Miki Mouse"));
        db.add(new Person(Long.parseLong("44"),"Miki Mouse 2"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeId() throws OperationNotSupportedException {
        // Act
        db.add(new Person(Long.parseLong("-1"),"Miki Mouse"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addPersonWithNullId() throws OperationNotSupportedException {
        // Act
        db.add(new Person(null,"Miki Mouse"));
    }
}