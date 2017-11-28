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

	public String countAndSay(int n) {
		String s = "";
		if (n == 1) {
			return "1";
		}
		if (n > 1) {
			s = "11";
			int k = 3;
			StringBuilder sb = new StringBuilder();
			while (k <= n) {
				int c = 1;
				for (int i = 1; i < s.length(); i++) {
					if (s.charAt(i) == s.charAt(i - 1)) {
						c++;
					} else {
						sb.append(c).append(s.charAt(i - 1));
						c = 1;
					}
				}
				sb.append(c).append(s.charAt(s.length() - 1));
				s = sb.toString();
				sb.setLength(0);
				k++;
			}
		}
		return s;
	}

	public void merge(int[] a, int m, int[] b, int n) {
		m--;
		n--;
		int k = a.length - 1;

		while (m >= 0 || n >= 0) {
			if (m >= 0 && n >= 0) {
				if (a[m] > a[n]) {
					a[k] = a[m];
					m--;
				} else {
					a[k] = b[n];
					n--;
				}
			} else if (m >= 0) {
				a[k] = a[m];
				m--;
			} else {
				a[k] = b[n];
				n--;
			}
			k--;
		}

	}

	public boolean isPalindrome(String s) {
		if (s == null) {
			return true;
		}
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		while (i <= j) {
			while (i < j && Character.isLetter(s.charAt(i))
					&& Character.isDigit(s.charAt(i)) == false) {
				i++;
			}
			while (i < j
					&& Character.isLetter(s.charAt(j)
							&& Character.isDigit(s.charAt(i))) == false) {
				j--;
			}
			if (i < j && s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

	List<String> list = new ArrayList<>();

	public List<String> addOperators(String num, int target) {
		if (num != null && num.isEmpty() == false) {
			operator(num, "", 0, 0, 0, target);
		}
		return list;
	}

	void operator(String num, String ex, int idx, int res, int prev, int target) {
		if (idx >= num.length()) {
			if (res == target) {
				list.add(ex);
				return;
			}
		}
		for (int i = idx; i < num.length(); i++) {
			String first = num.substring(idx, i + 1);
			Integer cur = Integer.parseInt(first);
			if (idx == 0) {
				operator(num, "" + cur, i + 1, res + cur, cur, target);
			} else {
				operator(num, ex + "+" + cur, i + 1, res + cur, cur, target);
				operator(num, ex + "-" + cur, i + 1, res - cur, cur, target);
				operator(num, ex + "*" + cur, i + 1, (res - prev) + prev * cur,
						prev * cur, target);
			}
		}
	}
	
    int []xa = {0, 1};
    int []ya = {1, 0};
    class Wrapper {
        @Override
		public String toString() {
			return "Wrapper [visited=" + visited + ", row=" + row + ", col="
					+ col + "]";
		}
		boolean visited;
        public int row;
        public int col;
        
    }
    Wrapper [][] p;
    int max = 0;;
    public int maximalRectangle(char[][] matrix) {
        p = new Wrapper[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (p[i][j] != null) {
                    _maximalRectangle(matrix, i, j);
                }
            }
        }
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (p[i][j] != null) {
                	System.out.print(p[i][j] +" "); 
                } else {
                	System.out.print("null");
                }
            }
            System.out.println();
        }
        
        return max;
    }
    
    public Wrapper _maximalRectangle(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length|| matrix[i][j] == 0) {
            return null;
        }
        
        if (p[i][j] != null) return p[i][j];
        
        p[i][j] = new Wrapper();
        p[i][j].row = 1;
        p[i][j].col = 1;
        
        Wrapper right =  _maximalRectangle(matrix, i + 0, j + 1);
        Wrapper down =  _maximalRectangle(matrix, i +1, j);
        if (right != null && down != null) {
            p[i][j].row = 1 + Math.min(right.row, down.row);
            p[i][j].col = 1 + Math.min(right.col, down.col);;
        } else if (right != null) {
            p[i][j].row = 1;
            p[i][j].col = right.col +1;
        } else if (down != null) {
            p[i][j].row = down.row +1;
            p[i][j].col = 1;
        }
        max = Math.max(max, p[i][j].row * p[i][j].col);
        return p[i][j];
    }
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    public boolean isMatch(String s, String p, int i, int j) {
        if (j >= p.length()) {
            if (i < s.length()) {
                return false;
            }
            return true;
        }
        
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return isMatch(s, p, i, j + 2)
            || (i < s.length() && s.charAt(i) == p.charAt(j) || '.' == p.charAt(j) ) && isMatch(s, p, i + 1, j);
        }
        if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            return  isMatch(s, p, i + 1, j + 1); 
        }
        return false;
    }
}
