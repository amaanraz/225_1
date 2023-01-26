package integeriterators;

import java.util.NoSuchElementException;

public class ArrayIterator implements IntegerIterator {
    // Class Variables
    private int iterator;
    private int[] array;
    private boolean infinite;

    // Creates an iterator for ar
    // Constructor (1 argument -> array)
    public ArrayIterator(int[] ar) {
        // init variables
        this.array = ar;
        this.iterator = 0;
        this.infinite = false;
    }

    /**
     * Creates an iterator for the ar
     * If isCircular is true, the iterator will be infinite,
     * outputting the array in circle
     * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
     */

    // Constructor (2 arguments)
    public ArrayIterator(int[] ar, boolean isCircular) {
        // init variables
        this.iterator = 0;
        this.array = ar;
        this.infinite = isCircular;
    }

    // Returns true if the array hasNext based on iterator count
    public boolean hasNext() {
        if(this.infinite){
            return true;
        }
        return this.iterator < this.array.length;
    }

    public Integer next() {
        // Check if there is a next element
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        // loop circular
        if(this.infinite){
            this.iterator = this.iterator % this.array.length;
        }


        return this.array[this.iterator++];
    }

    public void reset() {
        // reset iterator
        this.iterator = 0;
    }
}
