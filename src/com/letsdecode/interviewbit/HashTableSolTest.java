package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class HashTableSolTest {

	@Test
	public void anagrams() {
		HashTableWeek2Sol hashTableSol = new HashTableWeek2Sol();
		ArrayList<String> a = new ArrayList<>();
		a.add("cat");
		a.add("dog");
		a.add("god");
		a.add("tca");

		System.out.println(hashTableSol.anagrams(a));

	}

	@Test
	public void twoSum() {
		HashTableWeek2Sol hashTableSol = new HashTableWeek2Sol();
		int[] a = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4,
				1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i : a) {
			arr.add(i);
		}

		System.out.println(hashTableSol.twoSum(arr, -3));

	}

	@Test
	public void isValidSudoku() {
		HashTableWeek2Sol hashTableSol = new HashTableWeek2Sol();
		String[] a = { "....5..1.", ".4.3.....", ".....3..1", "8......2.",
				"..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
		ArrayList<String> arr = new ArrayList<>();
		for (String i : a) {
			arr.add(i);
		}
		System.out.println(hashTableSol.isValidSudoku(arr));
	}

}
