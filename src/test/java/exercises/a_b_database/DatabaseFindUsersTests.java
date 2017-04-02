package exercises.a_b_database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseFindUsersTests {

    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        // Arrange
        db = new Database();
        db.add(new Person((Long.parseLong("0")), "Spas Delev"));
        db.add(new Person((Long.parseLong("1")), "Stamat"));
        db.add(new Person((Long.parseLong("2")), "Genadi"));
        db.add(new Person((Long.parseLong("3")), "Jeko"));
        db.add(new Person((Long.parseLong("4")), "Strahil"));
    }

    @Test
    public void tryToFindAllFiveUsersByUsername() throws OperationNotSupportedException {
        // Act
        Human a = db.findByUsername("Spas Delev");
        Human b = db.findByUsername("Stamat");
        Human c = db.findByUsername("Genadi");
        Human d = db.findByUsername("Jeko");
        Human e = db.findByUsername("Strahil");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryToFindInvalidUsername() throws OperationNotSupportedException {
        // Act
        Human a = db.findByUsername("spas Delev");
    }

    @Test
    public void tryToFindAllFiveUsersById() throws OperationNotSupportedException {
        // Act
        Human a = db.findById(Long.parseLong("0"));
        Human b = db.findById(Long.parseLong("1"));
        Human c = db.findById(Long.parseLong("2"));
        Human d = db.findById(Long.parseLong("3"));
        Human e = db.findById(Long.parseLong("4"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryToFindInvalidId() throws OperationNotSupportedException {
        // Act
        Human a = db.findById(Long.parseLong("5"));
    }
}