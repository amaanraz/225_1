package integeriterators;

public class PrimeNumbersIterator implements IntegerIterator {

	private int iterator;
	private int start;
	// Defines all prime numbers
	public PrimeNumbersIterator() {
		// set to first prime number = 2
		this.iterator = 1;
		this.start = 1;
	}
	
	public PrimeNumbersIterator(int n) {
		// find the closest prime number >= n and set as start
		while(!isPrime(n)){
			n++;
		}
		this.iterator = n-1;
		this.start = n-1;
	}
	
	public boolean hasNext() {
		// infinite sequences
		return true;
	}
	
	public Integer next() {
		this.iterator++;
		// return next prime number
		while(!isPrime(this.iterator)){
			this.iterator++;
		}
		return this.iterator;
	}
	
	public void reset() {
		this.iterator = this.start;
	}

	private boolean isPrime(int n){
		// Edge cases
		if (n <= 1) return false;
		if (n == 2) return true;
		// Even numbers != prime numbers
		if (n % 2 == 0) return false;

		// Loop from 3 to sqrt(n) checking for prime
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
