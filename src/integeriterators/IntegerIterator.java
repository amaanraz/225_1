package integeriterators;

import java.util.Iterator;

public interface IntegerIterator extends Iterator<Integer>
{
	/**
	 * resets the iterator to the beginning of the sequence
	 */
	public void reset();
}
