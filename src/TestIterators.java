import integeriterators.*;


public class TestIterators
{

	public static void testArrayIterator1() {
		int ans[] = {4,3,8,2,5,8,11,14};
		
		ArrayIterator iter = new ArrayIterator(ans);
		for (int i=0; i<ans.length; i++)
			if (!iter.hasNext() || iter.next() != ans[i]) {
				System.out.println("testArrayIterator1 ERROR in iteration " + i);
				return;
			}

		if (iter.hasNext()) {
			System.out.println("testArrayIterator1 ERROR in hasNext()");
			return;
		}
		
		iter.reset();
		if (!iter.hasNext() || iter.next() != ans[0]) {
			System.out.println("testArrayIterator1 ERROR after reset");
			return;
		}
		
		System.out.println("testArrayIterator1 OK");
	}

	public static void testArrayIterator2() {
		int ans[] = {0,0,0,2,5,8,11,14};
		
		ArrayIterator iter = new ArrayIterator(ans, true);
		for (int i=0; i<3*ans.length+2; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length]) {
				System.out.println("testArrayIterator2 ERROR in iteration " + i);
				return;
			}

		if (!iter.hasNext()) {
			System.out.println("testArrayIterator2 ERROR");
			return;
		}
		
		iter.reset();
		if (!iter.hasNext() || iter.next() != ans[0]) {
			System.out.println("testArrayIterator2 ERROR after reset");
			return;
		}
		
		System.out.println("testArrayIterator2 OK");
	}

	public static void testArrayIterator3() {
		int ans[] = {0,0,0,2,5,8,11,14,13,19,2,3,4};

		ArrayIterator iter = new ArrayIterator(ans, true);
		for (int i=0; i<3*ans.length+2; i++)
			if (!iter.hasNext() || iter.next() != ans[i % ans.length]) {
				System.out.println("testArrayIterator2 ERROR in iteration " + i);
				return;
			}

		if (!iter.hasNext()) {
			System.out.println("testArrayIterator2 ERROR");
			return;
		}

		iter.reset();
		if (!iter.hasNext() || iter.next() != ans[0]) {
			System.out.println("testArrayIterator2 ERROR after reset");
			return;
		}

		System.out.println("testArrayIterator3 OK");
	}

	public static void testPrimes1()	{
		int primes[] = {2,3,5,7,11,13,17,19,23,29};
		
		PrimeNumbersIterator iter = new PrimeNumbersIterator();
		for (int i =0; i<primes.length; i++)
			if (!iter.hasNext() || iter.next() != primes[i]) {
				System.out.println("testPrimes1 ERROR in iteration " + i);
				return;
			}

		iter.reset();
		for (int i =0; i<primes.length-2; i++)
			if (!iter.hasNext() || iter.next() != primes[i]) {
				System.out.println("testPrimes1 ERROR after reset in iteration " + i);
				return;
			}
	
		System.out.println("testPrimes1 OK");
	}

	public static void testPrimes2() {
		int primes[] = {7,11,13,17,19,23,29};
		
		PrimeNumbersIterator iter = new PrimeNumbersIterator(7);
		for (int i =0; i<primes.length; i++)
			if (!iter.hasNext() || iter.next() != primes[i]) {
				System.out.println("testPrimes2 ERROR in iteration " + i);
				return;
			}

		System.out.println("testPrimes2 OK");
	}

	public static void testPrimes3() {
		int primes[] = {17,19,23,29,31,37,41};
		
		PrimeNumbersIterator iter = new PrimeNumbersIterator(14);
		for (int i =0; i<primes.length; i++)
			if (!iter.hasNext() || iter.next() != primes[i]) {
				System.out.println("testPrimes3 ERROR in iteration " + i);
				return;
			}

		System.out.println("testPrimes3 OK");
	}

	
	public static void testRangeIterator1()	{
		
		RangeIterator iter = new RangeIterator();
		for (int i=0; i<5; i++)
			if (!iter.hasNext() || iter.next() != i) {
				System.out.println("testRangeIterator1 ERROR in iteration " + i);
				return;
			}

		iter.reset();
		
		for (int i=0; i<10; i++)
			if (!iter.hasNext() || iter.next() != i) {
				System.out.println("testRangeIterator1 ERROR after reset in iteration " + i);
				return;
			}

		if (iter.hasNext())
			System.out.println("testRangeIterator1 OK");
		else
			System.out.println("testRangeIterator1 ERROR");
	}

	public static void testRangeIterator2()	{
		
		RangeIterator iter = new RangeIterator(25);
		for (int i=0; i<40; i++)
			if (!iter.hasNext() || iter.next() != 25+i) {
				System.out.println("testRangeIterator2 ERROR in iteration " + i);
				return;
			}

		
		for (int i=0; i<10; i++) {
			iter.reset();
			if (!iter.hasNext() || iter.next() != 25) {
				System.out.println("testRangeIterator2 ERROR after reset ");
				return;
			}
		}

		if (iter.hasNext())
			System.out.println("testRangeIterator2 OK");
		else
			System.out.println("testRangeIterator2 ERROR");
	}


	public static void testRangeIterator3()	{
		
		RangeIterator iter = new RangeIterator(25,30);
		for (int i=0; i<5; i++)
			if (!iter.hasNext() || iter.next() != 25+i) {
				System.out.println("testRangeIterator3 ERROR in iteration " + i);
				return;
			}


		if (iter.hasNext()) {
			System.out.println("testRangeIterator3 ERROR");
			return;
		}


		iter.reset();

		for (int i=0; i<5; i++)
			if (!iter.hasNext() || iter.next() != 25+i) {
				System.out.println("testRangeIterator3 ERROR in iteration " + i);
				return;
			}

		if (iter.hasNext())
			System.out.println("testRangeIterator3 ERROR");
		else
			System.out.println("testRangeIterator3 OK");
	}

	public static void main(String[] args) {
		testArrayIterator1();
		testArrayIterator2();
		testArrayIterator3();
		testPrimes1();
		testPrimes2();
		testPrimes3();
		testRangeIterator1();
		testRangeIterator2();
		testRangeIterator3();
	}
}