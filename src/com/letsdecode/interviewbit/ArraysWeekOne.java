package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ArraysWeekOne {
	/**
	 * Find Duplicate in Array - Week 1 - Assigment
	 * 
	 * @param a
	 * @return
	 */
	public int repeatedNumber(final List<Integer> a) {
		Collections.sort(a);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).equals(a.get(i - 1))) {
				return a.get(i);
			}
		}
		return -1;
	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a.size() == 0)
			return;
		int rows[] = new int[a.size()];
		Arrays.fill(rows, 1);
		int col[] = new int[a.get(0).size()];
		Arrays.fill(col, 1);
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).size(); j++) {
				if (a.get(i).get(j) == 0) {
					rows[i] = 0;
					col[j] = 0;
				}
			}
		}

		for (int j = 0; j < col.length; j++) {
			if (col[j] == 0) {
				for (int i = 0; i < rows.length; i++) {
					a.get(i).set(j, 0);
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == 0) {
				for (int j = 0; j < col.length; j++) {
					a.get(i).set(j, 0);
				}
			}
		}
	}

	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		return _numDecodings(s, 0);
	}

	public int _numDecodings(String s, int start) {
		if (start > s.length()) {
			return 1;
		}

		int res = 0;

		for (int i = start; i < start + 2 && i < s.length(); i++) {
			String first = s.substring(start, i + 1);
			int val = Integer.parseInt(first);
			if (first.charAt(0) == '0' || val > 26) {
				break;
			}
			res += _numDecodings(s, i + 1);
		}
		return res;
	}

	public void sortColors(int[] nums) {
		int i = 0;
		int j = 0;
		int k = nums.length - 1;
		int pivot = 1;
		while (j <= k) {
			if (nums[j] < pivot) {
				swap(nums, i, j);
				i++;
			} else if (nums[j] > pivot) {
				swap(nums, j, k);
				k--;
			}
			j++;
		}
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs(denominator);
		sb.append(num / den);
		num %= den;
		if (num == 0) {
			return sb.toString();
		}
		sb.append('.');
		HashMap<String, Integer> m = new HashMap<>();
		m.put("" + num, sb.length());
		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (m.containsKey("" + num)) {
				Integer index = m.get("" + num);
				sb.insert(index, "(").append("");
				break;
			} else {
				m.put("" + num, sb.length());
			}
		}
		return sb.toString();
	}

	ArrayList<Integer> list = new ArrayList<>();
	int size = 0;
	HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
	Random r = new Random();

	/** Initialize your data structure here. */

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		// Add element to the list
		if (size < list.size()) {
			list.set(size, val);
		} else {
			list.add(val);
		}

		// increase the size
		size++;
		LinkedList<Integer> l = null;
		boolean ret = false;
		if (map.containsKey(val) == false) {
			// add linked list to maintain the indices
			l = new LinkedList<Integer>();
			map.put(val, l);
			ret = true;
		} else {
			l = map.get(val);
		}
		l.addFirst(size - 1);
		return ret;

	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val) == false) {
			return false;
		}
		LinkedList<Integer> l = map.get(val);
		if (l.size() == 1) {
			// Update the map
			map.remove(val);
		}
		if (list.size() == 1) {
			// this is the last element
			size = 0;
			list.clear();
			return true;
		}
		int index = l.getFirst();
		int lastElement = list.get(size - 1);
		if (map.get(lastElement) != null) {
			int replaceIndex = map.get(lastElement).removeFirst();
			swap(index, replaceIndex, list);
			map.get(lastElement).addFirst(index);
		}
		size--;
		return true;
	}

	void swap(int i, int j, ArrayList<Integer> list) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		if (size == 0) {
			return -1;
		}
		int index = r.nextInt(size);
		return list.get(index);
	}

	class Pair {
		int rating;
		int index;

		public Pair(int rating, int index) {
			this.rating = rating;
			this.index = index;

		}
	}

	PriorityQueue<Pair> pq;

	public int candy(int[] ratings) {
		int c[] = new int[ratings.length];
		Arrays.fill(c, 1);

		pq = new PriorityQueue<>(ratings.length, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.rating - o2.rating;
			}
		});
		for (int i = 0; i < ratings.length; i++) {
			pq.add(new Pair(ratings[i], i));
		}
		int sum = 0;
		while (pq.isEmpty() == false) {
			Pair p = pq.poll();
			int left = 0;
			if (p.index - 1 >= 0 && ratings[p.index] > ratings[p.index - 1]) {
				left = c[p.index - 1] + 1;
			}
			int right = 0;
			if (p.index + 1 < ratings.length
					&& ratings[p.index] > ratings[p.index + 1]) {
				right = c[p.index + 1] + 1;
			}
			int val = Math.max(c[p.index], Math.max(left, right));
			c[p.index] = val;
			sum += val;
		}
		return sum;
	}
}
