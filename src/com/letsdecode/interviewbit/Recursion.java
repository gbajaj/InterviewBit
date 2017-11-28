package com.letsdecode.interviewbit;

import java.util.ArrayList;

public class Recursion {
	String digits[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };
	ArrayList<String> retVal = new ArrayList<String>();

	public ArrayList<String> letterCombinations(String a) {
		char arr[] = a.toCharArray();
		int i = 0;

		_letterCombinations(a, arr, i);
		return retVal;
	}

	void _letterCombinations(String s, char[] a, int i) {
		if (i >= a.length) {
			retVal.add(new String(a));
			return;
		}
		char ch = s.charAt(i);
		String d = digits[ch - '0'];
		for (int j = 0; j < d.length(); j++) {
			a[i] = d.charAt(j);
			_letterCombinations(s, a, i + 1);
		}
	}

	ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		char c[][] = new char[a][a];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = '.';
			}
		}
		boolean b[] = new boolean[a];
		_solveNQueens(c, 0, b);

		return ret;
	}

	void _solveNQueens(char[][] c, int i, boolean b[]) {
		if (i >= c.length) {
			ArrayList<String> t = new ArrayList<String>();
			for (int j = 0; j < c.length; j++) {
				t.add(new String(c[j]));
			}
			ret.add(t);
			return;
		}

		for (int j = 0; j < b.length; j++) {
			if (b[j] || checkLeft(c, i, j) || checkRight(c, i, j)) {
				continue;
			}
			c[i][j] = 'Q';
			b[j] = true;
			_solveNQueens(c, i + 1, b);
			c[i][j] = '.';
			b[j] = false;
		}

	}

	boolean checkLeft(char[][] c, int i, int j) {
		for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
			if (c[row][col] == 'Q')
				return true;
		}
		return false;
	}

	boolean checkRight(char[][] c, int i, int j) {
		for (int row = i - 1, col = j + 1; row >= 0 && col < c[row].length; row--, col++) {
			if (c[row][col] == 'Q')
				return true;
		}
		return false;
	}

	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	ArrayList<ArrayList<Integer>> permute(int[] a) {
		_permute(a, 0);
		return res;
	}

	void _permute(int[] a, int index) {
		if (index >= a.length) {
			// add the result;
			res.add(toList(a));// 123, 132, 2 1 3, 2 3 1;
			return;
		}
		for (int i = index; i < a.length; i++) {
			swap(a, i, index);
			_permute(a, index + 1);// 1 , 2
			swap(a, i, index);
		}

	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;

	}

	ArrayList<Integer> toList(int a[]) {
		ArrayList<Integer> re = new ArrayList<>();
		for (int i : a) {
			re.add(i);
		}
		return re;

	}
}
