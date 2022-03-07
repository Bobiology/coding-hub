/**
 * 
 */
package codility.im;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author sakawaelijahbob
 *
 */
class TestDemo {

	@Test
	void testNull() {
		assertEquals(MaxNumberFromString.maxValue(null), 0);
	}
	
	@Test
	void testEmpty() {
		assertEquals(MaxNumberFromString.maxValue(""), 0);
	}

	@Test
	void testStringsOnly() {
		assertEquals(MaxNumberFromString.maxValue("aaasssddd"), 0);
	}
	
	@Test
	void testNumbersOnly() {
	    assertEquals(MaxNumberFromString.maxValue("9999hhh"), 9999);
	}
	
	@Test
	void testNumbersString() {
		assertEquals(MaxNumberFromString.maxValue("qqqww99yyyy99ooo78lll100"), 100);
	}

}
