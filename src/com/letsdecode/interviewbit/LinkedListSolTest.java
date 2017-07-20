package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.letsdecode.interviewbit.LinkedListWeek2Sol.ListNode;

public class LinkedListSolTest {

	@Test
	public void test() {
		int[] f = { 5, 8, 20 };
		int[] s = { 4, 11, 15 };
		ListNode l1 = createList(f);
		ListNode l2 = createList(s);
		LinkedListWeek2Sol sol = new LinkedListWeek2Sol();
		ListNode out = sol.mergeTwoLists(l1, l2);
		print(out);

	}

	@Test
	public void detectCycle() {
		int[] f = { 11, 87797, 23219, 41441, 58396, 48953, 94603, 2721, 95832,
				49029, 98448, 65450 };
		ListNode l1 = createList(f);
		LinkedListWeek2Sol sol = new LinkedListWeek2Sol();
		sol.detectCycle(null);
	}

	void print(ListNode list) {
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}

	ListNode createList(int[] a) {
		ListNode h = new ListNode(0);
		ListNode c = h;
		for (int i : a) {
			c.next = new ListNode(i);
			c = c.next;
		}
		return h.next;

	}
}
