package exercises.c_iterator;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorPrintTests {

    private static final String EXPECTED_FIRST_ELEMENT = "a";

    @Test (expected = OperationNotSupportedException.class)
    public void tryPrintOnEmptyCollection() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator();
        // Act
        String actualValue = iterator.print();
    }

    @Test
    public void tryPrintOnNormal() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a", "b");
        // Act
        String actualValue = iterator.print();
        // Assert
        Assert.assertEquals("Expect to print first element", EXPECTED_FIRST_ELEMENT, actualValue);
    }
}