package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };
		List<Integer> l = list(a);
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(l, 4));

	}

	@Test
	public void binarySearch() {

		int a = 11;
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.sqrt(930675566));

	}

	ArrayList<Integer> list(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			l.add(a[i]);
		}
		return l;
	}

	@Test
	public void searchRange() {

		int a[] = { 5 };
		ArrayList<Integer> al = list(a);
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.searchRange(al, 5));

	}



}
