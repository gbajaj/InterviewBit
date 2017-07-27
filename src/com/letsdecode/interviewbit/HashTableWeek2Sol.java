package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashTableWeek2Sol {
	/**
	 * Pre Work
	 * @param a
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		HashMap<String, ArrayList<Integer>> m = new HashMap<>();
		int i = 1;
		for (String s : a) {
			char c[] = s.toCharArray();
			Arrays.sort(c);
			String t = new String(c);
			ArrayList<Integer> o = m.get(t);
			if (o == null) {
				o = new ArrayList<Integer>();
				m.put(t, o);
			}
			o.add(i);
			i++;
		}
		for (String key : m.keySet()) {
			list.add(m.get(key));
		}
		return list;
	}

	/**
	 * Pre Work
	 * @param a
	 * @param b
	 * @return
	 */
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		ArrayList<Integer> out = new ArrayList<>();
		HashMap<Integer, Integer> m = new HashMap<>();
		int in = 0;
		for (int k = a.size() - 1; k >= 0; k--) {
			int i = a.get(k);
			in++;
			if (m.containsKey(i)) {
				continue;
			}
			m.put(i, in);

		}
		int index2 = Integer.MAX_VALUE;
		int index1 = Integer.MAX_VALUE;
		in = 1;
		for (Integer f : a) {
			int diff = b - f;
			if (m.containsKey(diff) && in < m.get(diff)) {
				index2 = m.get(diff);
				index1 = in;
			}
			in++;
		}
		if (index2 != Integer.MAX_VALUE) {
			out.add(index1);
			out.add(index2);
		}
		return out;
	}

	/**
	 * Post Work 
	 * @param a
	 * @return
	 */
	public int isValidSudoku(final List<String> a) {
		for (String s : a) {
			boolean res = isValidRow(s);
			if (res == false) {
				return 0;
			}
		}
		for (int i = 0; i < 9; i++) {
			boolean res = isValidColumn(a, i);
			if (res == false) {
				return 0;
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				boolean res = isValidSub(i, j, a);
				if (res == false) {
					return 0;
				}
			}
		}
		return 1;
	}

	boolean isValidRow(String s) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '.') {
				if (set.contains(s.charAt(i))) {
					return false;
				}
				set.add(s.charAt(i));
			}
		}
		return true;
	}

	boolean isValidColumn(List<String> l, int in) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < l.size(); i++) {
			String s = l.get(i);
			if (s.charAt(in) != '.') {
				if (set.contains(s.charAt(in))) {
					return false;
				}
				set.add(s.charAt(in));
			}
		}
		return true;
	}

	boolean isValidSub(int k, int l, List<String> list) {
		HashSet<Character> set = new HashSet<>();

		for (int i = k; i < k + 3; i++) {
			for (int j = l; j < l + 3; j++) {
				String s = list.get(i);
				if (s.charAt(j) != '.') {
					if (set.contains(s.charAt(j))) {
						return false;
					}
					set.add(s.charAt(j));
				}
			}
		}
		return true;
	}

	/**
	 * Post Work
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		sb.append(num / den);
		num %= den;
		if (num == 0) {
			return sb.toString();
		}
		sb.append('.');
		HashMap<Long, Integer> m = new HashMap<>();
		m.put(num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (m.containsKey(num)) {
				int index = m.get(num);
				sb.insert(index, '(').append(')');
				break;
			} else {
				m.put(num, sb.length());
			}
		}

		return sb.toString();
	}

	/**
	 * Post Work
	 * @param a
	 * @return
	 */
	public int lengthOfLongestSubstring(String a) {
		HashMap<Character, Integer> m = new HashMap<>();
		int max = 0;
		int start = 0;
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			Character c = a.charAt(i);
			Integer val = m.get(c);
			m.put(c, i);
			if (val != null && val >= start) {
				start = val + 1;
			}
			max = Math.max(max, i + 1 - start);
		}
		return max;
	}
}
