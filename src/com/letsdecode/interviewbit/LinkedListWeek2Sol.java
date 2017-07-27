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

	/**
	 * Pre Work
	 * @param a
	 * @param b
	 * @return
	 */
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

	/**
	 * List Cycle
	 * Pre Work
	 * @param a
	 * @return
	 */
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
		if (f != s)
			return null;
		while (head != s) {
			head = head.next;
			s = s.next;
		}
		return head;
	}

	/**
	 * Sort List
	 * 
	 * @param a
	 * @return
	 */
	public ListNode sortList(ListNode a) {
		if (a == null || a.next == null) {
			return a;
		}
		ListNode mid = partition(a);
		ListNode right = mid.next;
		mid.next = null;
		ListNode left = sortList(a);
		right = sortList(right);
		return merge(left, right);
	}

	public ListNode partition(ListNode a) {
		ListNode slow = a;
		ListNode fast = a;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * Merge Two Sorted Lists Post Work
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) {
				head.next = a;
				a = a.next;
			} else {
				head.next = b;
				b = b.next;
			}
			head = head.next;
		}
		while (a != null) {
			head.next = a;
			a = a.next;
			head = head.next;
		}

		while (b != null) {
			head.next = b;
			b = b.next;
			head = head.next;
		}

		return dummy.next;
	}

	/**
	 * Swap List Nodes in pairs Post Work
	 * 
	 * @param a
	 * @return
	 */
	public ListNode swapPairs(ListNode a) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		ListNode slow = a;
		ListNode fast = a;
		if (slow == null || slow.next == null) {
			return slow;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre.next = slow.next;
			slow.next.next = slow;
			slow.next = fast;
			pre = slow;
			slow = fast;
		}

		return dummy.next;
	}
}
