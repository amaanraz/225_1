package integeriterators;

import java.util.NoSuchElementException;

public class RangeIterator implements IntegerIterator
{
	private int iterator;
	private int start;
	private int end;
	private boolean infinte;
	/**
	 * Creates an iterator for the infinite sequence 0,1,2,...
	 */
	public RangeIterator() {
		// infinite sequence from 1 to infinity
		this.iterator = 0;
		this.start = 0;
		this.end = 0;
		this.infinte = true;
	}
	
	/**
	 * Creates an iterator for the infinite sequence s,s+1,s+2...
	 */
	public RangeIterator(int s) {
		this.iterator = s;
		this.start = s;
		this.end = 0;
		this.infinte = true;
	}
	
	/**
	 * Creates an iterator for the finite sequence [s,s+1,s+2...t-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int s, int t) {
		// TODO add try catch block
		try{
			this.iterator = s;
			this.start = s;
			this.end = t;
			this.infinte = false;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean hasNext() {
		int temp = this.iterator;
		// always true -> infinite sequences
		if(!this.infinte){
			return temp++ != this.end;
		}
		return true;
	}
	
	public Integer next() {
		if(!hasNext()){
			throw new NoSuchElementException();
		}

		return this.iterator++;
	}
	
	public void reset() {
		// assign to start
		this.iterator = this.start;
	}
}
