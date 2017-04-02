package exercises.a_b_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseRemoveTests {

    private static final int EXPEXTED_DB_ELEMENTS_SIZE = 4;
    private static final int EXPECTED_EMPTY_DB_SIZE = 0;
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
    public void removePersonWithCorrectId() throws OperationNotSupportedException {
        // Act
        db.remove(Long.parseLong("0"));
        int actualSize = db.getElements().size();
        // Assert
        Assert.assertEquals("DB elements size to be 4", EXPEXTED_DB_ELEMENTS_SIZE, db.getElements().size());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void removePersonWithCorrectIdAndAfterThatTryToFindItByName() throws OperationNotSupportedException {
        // Act
        db.remove(Long.parseLong("0"));
        int actualSize = db.getElements().size();
        // Expect error here
        db.findByUsername("Spas Delev");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void removePersonWithCorrectIdAndAfterThatTryToFindItById() throws OperationNotSupportedException {
        // Act
        db.remove(Long.parseLong("0"));
        int actualSize = db.getElements().size();
        // Expect error here
        db.findById(Long.parseLong("0"));
    }

    @Test
    public void removeAllElementsFromDbAndCheskIsItEmpty() throws OperationNotSupportedException {
        // Act
        db.remove(Long.parseLong("0"));
        db.remove(Long.parseLong("1"));
        db.remove(Long.parseLong("2"));
        db.remove(Long.parseLong("3"));
        db.remove(Long.parseLong("4"));
        int actualSize = db.getElements().size();
        // Assert
        Assert.assertEquals("Expect DB to be empty", EXPECTED_EMPTY_DB_SIZE, actualSize);
    }
}