package codility.unit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codility.MinimumPositiveInteger;

class MinimumPositiveIntegerTest {

	@Test
	void minimumPositveTestOne() {
		int[]A = {1,2,3};
		assertEquals(4,  new MinimumPositiveInteger().solution(A));
	}
	
	@Test
	void minimumPositveTestTwo() {
		int[]A = {1,3,6,4,1,2};
		assertEquals(5,  new MinimumPositiveInteger().solution(A));
	}
	
	@Test
	void minimumPositveTestThree() {
		int[]A = {-1,-3};
		assertEquals(1,  new MinimumPositiveInteger().solution(A));
	}

}
