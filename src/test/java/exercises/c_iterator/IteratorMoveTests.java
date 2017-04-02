package exercises.c_iterator;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class IteratorMoveTests {

    @Test
    public void tryMoveOnEmptyCollection() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator();
        // Act
        boolean actualValue = iterator.move();
        // Assert
        Assert.assertEquals("Expected false on empty list",false, actualValue);
    }

    @Test
    public void tryMoveOnLastIndex() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a");
        // Act
        boolean actualValue = iterator.move();
        // Assert
        Assert.assertEquals("Expected false on last element in list",false, actualValue);
    }

    @Test
    public void tryMoveOnValidIndex() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a", "b");
        // Act
        boolean actualValue = iterator.move();
        // Assert
        Assert.assertEquals("Expected false on last element in list",true, actualValue);
    }

    @Test
    public void tryMOreMovesOnBiggerCollection() throws OperationNotSupportedException {
        // Arrange
        ListIterator iterator = new ListIterator("a", "b", "c", "d", "e", "f");
        // Act
        boolean move1 = iterator.move();
        boolean move2 = iterator.move();
        boolean move3 = iterator.move();
        boolean move4 = iterator.move();
        boolean move5 = iterator.move();
        boolean move6 = iterator.move();
        // Assert
        Assert.assertEquals("Expected true on first move",true, move1);
        Assert.assertEquals("Expected true on second move",true, move2);
        Assert.assertEquals("Expected true on third move",true, move3);
        Assert.assertEquals("Expected true on fourth move",true, move4);
        Assert.assertEquals("Expected true on fifth move",true, move5);
        Assert.assertEquals("Expected false on sixth move",false, move6);
    }
}