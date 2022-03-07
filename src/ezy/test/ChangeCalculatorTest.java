package ezy.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ChangeCalculatorTest {

	@Test
	void firstTestCase() {
		int[] coins = {0,1,0,0,1,1};
		double amount=3.05, cost=1.5;
		assertEquals(Arrays.toString(coins), Arrays.toString(new ChangeCalculator().getChange(amount, cost)));
	}
	@Test
	void secondTestCase() {
		int[] coins = {0,1,1,0,0,1};
		double amount=3.14, cost=1.99;
		assertEquals(Arrays.toString(coins), Arrays.toString(new ChangeCalculator().getChange(amount, cost)));
	}
	
	@Test
	void thirdTestCase() {
		int[] coins = {4,0,2,1,1,2};
		double amount=3, cost=0.01;
		assertEquals(Arrays.toString(coins), Arrays.toString(new ChangeCalculator().getChange(amount, cost)));
	}
	
	@Test
	void fourthTestCase() {
		int[] coins = {1,0,1,1,1,0};
		double amount=4, cost=3.14;
		assertEquals(Arrays.toString(coins), Arrays.toString(new ChangeCalculator().getChange(amount, cost)));
	}
	
	@Test
	void fifthTestCase() {
		int[] coins = {1,0,1,0,0,0};
		double amount=0.45, cost=0.34;
		assertEquals(Arrays.toString(coins), Arrays.toString(new ChangeCalculator().getChange(amount, cost)));
	}

}
