package com.letsdecode.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import sun.security.util.Length;

public class Solution {
	/**
	 * Checkpoint: Level 2 Prettyprint
	 * 
	 * @param a
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		int len = (a * 2) - 1;
		ArrayList<ArrayList<Integer>> out = new ArrayList<>(len);

		for (int i = 0; i < len; i++) {
			out.add(new ArrayList<Integer>(Collections.nCopies(len, 0)));
		}

		if (a <= 0) {
			return out;
		}
		int k = (a * 2) - 2;
		int val = a;
		int r = len - 1;
		for (int i = 0; i <= k; i++) {
			ArrayList<Integer> t = out.get(i);
			// Top
			for (int c = i; c <= k; c++) {
				t.set(c, val);
			}
			// Right
			for (int l = i + 1; l <= r; l++) {
				out.get(l).set(k, val);
			}
			k--;
			for (int c = k; c >= i; c--) {
				out.get(r).set(c, val);
			}

			r--;
			for (int l = r; l > i; l--) {
				out.get(l).set(i, val);
			}
			val--;
		}
		return out;
	}

	/**
	 * Checkpoint: Level 3 Kth Smallest Element in the Array
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	public int kthsmallest(final List<Integer> a, int k) {
		if (a.size() < k) {
			return 1;
		}
		Collections.sort(a);
		return a.get(k - 1);

	}

	class ListNode {
		ListNode next;
		int val;
	}

	/**
	 * Checkpoint: Level 4 SUBTRACT
	 * 
	 * @param a
	 * @return
	 */
	public ListNode subtract(ListNode a) {
		if (a == null)
			return null;
		if (a.next == null)
			return a;
		if (a.next.next == null) {
			a.val = a.next.val - a.val;
			return a;
		}
		ListNode slow = a;
		ListNode fast = a;
		ListNode pre = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		ListNode sec = pre.next;
		pre.next = null;
		sec = reverse(sec);
		ListNode cur = a;
		ListNode secHead = sec;
		while (cur != null) {
			cur.val = secHead.val - cur.val;
			cur = cur.next;
			secHead = secHead.next;
		}
		sec = reverse(sec);
		pre.next = sec;
		return a;
	}

	public ListNode reverse(ListNode head) {
		ListNode p = null, q = null, r = head;
		while (r != null) {
			q = r;
			r = r.next;
			q.next = p;
			p = q;
		}
		return q;
	}

	/**
	 * Checkpoint Level 5: Longest Consecutive Sequence
	 * 
	 * @param a
	 * @return
	 */
	public int longestConsecutive(final List<Integer> a) {
		HashMap<Integer, Integer> m = new HashMap<>();
		int max = 0;
		for (int i = 0; i < a.size(); i++) {
			if (m.containsKey(a.get(i)) == false) {
				Integer low = m.get(a.get(i) - 1);
				Integer high = m.get(a.get(i) + 1);
				if (low == null) {
					low = 0;
				}
				if (high == null) {
					high = 0;
				}
				int c = 1 + low + high;
				m.put(a.get(i), c);
				m.put(a.get(i) - low, c);
				m.put(a.get(i) + high, c);
				max = Math.max(max, c);
			}
		}
		return max;
	}

	// Problems to solve before the session one
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval p = res.get(res.size() - 1);
			Interval c = intervals.get(i);
			if (c.start >= p.start) {
				if (c.start <= p.end) {
					p.start = Math.min(c.start, p.start);
					p.end = Math.max(p.end, c.end);
				} else {
					res.add(new Interval(c.start, c.end));
				}
			}
		}

		return res;
	}

	public int isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return 1;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			while (i < j && Character.isLetterOrDigit(s.charAt(i)) == false) {
				i++;
			}
			while (i < j && Character.isLetterOrDigit(s.charAt(j)) == false) {
				j--;
			}
			if (i <= j) {
				if (Character.toLowerCase(s.charAt(i)) != Character
						.toLowerCase(s.charAt(j))) {
					return 0;
				}
				i++;
				j--;
			}

		}
		return 1;
	}

	/**
	 * Reverse the String Week 1 Pre
	 * 
	 * @param a
	 * @return
	 */
	public String reverseWords(String a) {
		if (a == null || a.isEmpty()) {
			return a;
		}
		StringBuilder sb = new StringBuilder(a.trim());
		a = sb.reverse().toString();
		String[] s = a.split(" ");
		sb.setLength(0);
		for (int i = 0; i < s.length; i++) {
			if (s[i].isEmpty() == false) {
				sb.append((new StringBuilder(s[i]).reverse().toString()));
			}
			if (i < s.length - 1 && s[i + 1].isEmpty() == false) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * Add One To Number
	 * 
	 * @param a
	 * @return
	 */
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> res = new ArrayList<>();
		int carry = 1;
		int i = 0;
		for (i = a.size() - 1; i >= 0; i--) {
			if (a.get(i) == 9) {
				a.set(i, 0);
			} else {
				a.set(i, a.get(i) + 1);
				carry = 0;
				break;
			}
		}
		if (carry == 1) {
			a.add(0, 1);
		}
		for (i = 0; i < a.size(); i++) {
			if (a.get(i) == 0) {
				continue;
			} else
				break;
		}
		for (; i < a.size(); i++) {
			res.add(a.get(i));
		}

		return res;
	}



}
