package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysWeekOneTest {

	@Test
	public void test() {
		ArraysWeekOne aw = new ArraysWeekOne();
		System.out.println(aw.numDecodings("100"));
		System.out.println(aw.numDecodings("01"));
		System.out.println(aw.numDecodings(""));
	}

	@Test
	public void sortColors() {
		ArraysWeekOne aw = new ArraysWeekOne();
		int [] a = {0, 2, 1};
		aw.sortColors(a);
	}

	@Test
	public void fractionToDecimal() {
		ArraysWeekOne aw = new ArraysWeekOne();
		int [] a = {0, 2, 1};
		aw.fractionToDecimal(1, 5);
	}
	
	@Test
	public void randomTest() {
		ArraysWeekOne aw = new ArraysWeekOne();
		aw.insert(3);
		aw.insert(3);
		aw.getRandom();
		aw.getRandom();
		
		aw.insert(1);
		aw.remove(3);
		aw.getRandom();
		aw.getRandom();
		aw.insert(0);
		aw.remove(0);
		
	}

}
