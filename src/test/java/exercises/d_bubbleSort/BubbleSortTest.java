package exercises.d_bubbleSort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    private static final int FIRST_SORTED_ELEMENT = -6;
    private static final int SECOND_SORTED_ELEMENT = -1;
    private static final int THIRD_SORTED_ELEMENT = 1;
    private static final int FOURTH_SORTED_ELEMENT = 3;
    private static final int FIFTH_SORTED_ELEMENT = 5;
    private static final int EMPTY_COLLECTION_SIZE = 0;

    @Test
    public void sortNormalCollection() {
       // Arrange
        int [] arr = {THIRD_SORTED_ELEMENT, FOURTH_SORTED_ELEMENT, FIFTH_SORTED_ELEMENT, SECOND_SORTED_ELEMENT , FIRST_SORTED_ELEMENT};
        // Act
        BubbleSort.bubbleSort(arr);
        int firstElement = arr[0];
        int secondElement = arr[1];
        int thirdElement = arr[2];
        int fourthElement = arr[3];
        int fifthElement = arr[4];
        // Assert
        Assert.assertEquals("First element must be -6", FIRST_SORTED_ELEMENT, firstElement);
        Assert.assertEquals("Second element must be -1", SECOND_SORTED_ELEMENT, secondElement);
        Assert.assertEquals("Third element must be 1", THIRD_SORTED_ELEMENT, thirdElement);
        Assert.assertEquals("Fourth element must be 3", FOURTH_SORTED_ELEMENT, fourthElement);
        Assert.assertEquals("Fifth element must be 5", FIFTH_SORTED_ELEMENT, fifthElement);
    }

    @Test
    public void sortSortedCollection() {
        // Arrange
        int [] arr = {FIRST_SORTED_ELEMENT, SECOND_SORTED_ELEMENT, THIRD_SORTED_ELEMENT, FOURTH_SORTED_ELEMENT, FIFTH_SORTED_ELEMENT};
        // Act
        BubbleSort.bubbleSort(arr);
        int firstElement = arr[0];
        int secondElement = arr[1];
        int thirdElement = arr[2];
        int fourthElement = arr[3];
        int fifthElement = arr[4];
        // Assert
        Assert.assertEquals("First element must be -6", FIRST_SORTED_ELEMENT, firstElement);
        Assert.assertEquals("Second element must be -1", SECOND_SORTED_ELEMENT, secondElement);
        Assert.assertEquals("Third element must be 1", THIRD_SORTED_ELEMENT, thirdElement);
        Assert.assertEquals("Fourth element must be 3", FOURTH_SORTED_ELEMENT, fourthElement);
        Assert.assertEquals("Fifth element must be 5", FIFTH_SORTED_ELEMENT, fifthElement);
    }

    @Test
    public void sortEmptyCollection() {
        // Arrange
        int [] arr = {};
        // Act
        BubbleSort.bubbleSort(arr);
        // Assert
        Assert.assertEquals("Collection must be empty",EMPTY_COLLECTION_SIZE, arr.length);
    }

    @Test
    public void sortCollectionWithSameValues() {
        // Arrange
        int [] arr = {FIRST_SORTED_ELEMENT, FIRST_SORTED_ELEMENT, FIRST_SORTED_ELEMENT, FIRST_SORTED_ELEMENT};
        // Act
        BubbleSort.bubbleSort(arr);
        int firstElement = arr[0];
        int secondElement = arr[1];
        int thirdElement = arr[2];
        int fourthElement = arr[3];
        // Assert
        Assert.assertEquals("First element must be -6", FIRST_SORTED_ELEMENT, firstElement);
        Assert.assertEquals("Second element must be -6",FIRST_SORTED_ELEMENT, secondElement);
        Assert.assertEquals("Third element must be -6", FIRST_SORTED_ELEMENT, thirdElement);
        Assert.assertEquals("Fourth element must be -6",FIRST_SORTED_ELEMENT, fourthElement);
    }
}