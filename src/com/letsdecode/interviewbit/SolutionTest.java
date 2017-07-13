package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.letsdecode.interviewbit.Solution.Interval;

public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(s.new Interval(1, 4));
		intervals.add(s.new Interval(2, 5));

		new Solution().insert(intervals, s.new Interval(2, 3));
	}

	@Test
	public void isPalindrome() {
		Solution s = new Solution();
		System.out.println(s.isPalindrome("1a2"));
	}

	@Test
	public void reverseWords() {
		Solution s = new Solution();
		System.out.println(s.reverseWords("1a2"));

	}
	
	@Test
	public void plusOne() {
		Solution s = new Solution();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(9);
		System.out.println(s.plusOne(list));

	}
	

	

}
