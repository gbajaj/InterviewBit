package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.letsdecode.interviewbit.LinkedListWeek2Sol.ListNode;


public class HeapProblems {
	/**
	 * Pre Work
	 * @param a
	 * @return
	 */
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    ListNode dummy = new ListNode (0);
	    ListNode head = dummy;
	    PriorityQueue<ListNode> q = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
	    	@Override
	    	public int compare(ListNode o1, ListNode o2) {
	    		return o1.val - o2.val;
	    	}
		});
	    for (ListNode c: a){
	        q.add(c);
	    }
	    
	    while (q.isEmpty() == false) {
	        ListNode l = q.poll();
	        head.next = l;
	        head = head.next;
	        l = l.next;
	        if (l != null) {
	            q.offer(l);
	        }
	    }
	    return dummy.next;
	    
	}
	
	
}
