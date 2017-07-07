package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
}
