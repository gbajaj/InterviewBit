package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitManipulationTest {

	@Test
	public void test() {
		BitManipulation bitManipulation = new BitManipulation();
		System.out.println(bitManipulation.reverse(3));
		
	}
	@Test
	public void numSetBits() {
		BitManipulation bitManipulation = new BitManipulation();
		System.out.println(bitManipulation.numSetBits(3));
		
	}

	@Test
	public void findMaximumXOR() {
		int a[] = {3, 10, 5, 25, 2, 8};
		BitManipulation bitManipulation = new BitManipulation();
		System.out.println(bitManipulation.findMaximumXOR(a));
		
	}

	@Test
	public void divide() {
		
		BitManipulation bitManipulation = new BitManipulation();
		System.out.println(bitManipulation.divide(Integer.MIN_VALUE, -1));
		
	}
	
	@Test
	public void hammingDistance() {
		
		BitManipulation bitManipulation = new BitManipulation();
		System.out.println(bitManipulation.hammingDistance(93, 73));
		
	}

	

	

}
