package com.letsdecode.interviewbit;

public class LinkedListWeek2Sol {
	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode ret = new ListNode(0);
		ListNode cur = ret;
		while (a != null || b != null) {
			if (a != null && b != null) {
				if (a.val < b.val) {
					cur.next = a;
					a = a.next;
				} else {
					cur.next = b;
					b = b.next;
				}

			} else if (a != null) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		cur.next = null;
		return ret.next;
	}

	public ListNode detectCycle(ListNode a) {
		ListNode head = a;
		ListNode s = a;
		ListNode f = a;
		while (f != null && f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
			if (f == s) {
				break;
			}
		}
		if (f != s) return null;
		while (head != s) {
			head = head.next;
			s = s.next;
		}
		return head;
	}

}
