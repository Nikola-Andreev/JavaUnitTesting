package exercises.c_iterator;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorHasNextTests {

    @Test
    public void tryMoveOnEmptyCollection() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator();
        // Act
        boolean actualValue = iterator.hasNext();
        // Assert
        Assert.assertEquals("Expected false on empty list",false, actualValue);
    }

    @Test
    public void tryMoveOnLastIndex() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a");
        // Act
        boolean actualValue = iterator.hasNext();
        // Assert
        Assert.assertEquals("Expected false with one element in list", false, actualValue);
    }

    @Test
    public void tryMoveOnValidIndex() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a", "b");
        // Act
        boolean actualValue = iterator.hasNext();
        // Assert
        Assert.assertEquals("Expected true with two elements in the list", true, actualValue);
    }
}