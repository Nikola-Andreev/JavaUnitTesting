package exercises.c_iterator;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

public class ListIterator {

    private List<String> collection;
    private int currentIndex;

    public ListIterator(String... collection) throws OperationNotSupportedException {
        this.setCollection(collection);
        this.currentIndex = 0;
    }

    private void setCollection(String[] collection) throws OperationNotSupportedException {
        if (collection == null) {
            throw new OperationNotSupportedException("Parameters cannot be null!");
        }
        this.collection = Arrays.asList(collection);
    }

    public boolean move() {
        if (this.hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.currentIndex + 1 < this.collection.size();
    }

    public String print() throws OperationNotSupportedException {
        if (this.collection.isEmpty()) {
            throw new OperationNotSupportedException("The list is emty!");
        }

        return this.collection.get(this.currentIndex);
    }
}
