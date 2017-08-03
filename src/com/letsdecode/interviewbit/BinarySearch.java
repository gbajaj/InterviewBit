package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public int search(final List<Integer> a, int b) {
		int l = 0;
		int h = a.size() - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a.get(m) == b) {
				return m;
			}
			if (a.get(l) <= a.get(m)) {
				if (b >= a.get(l) && b < a.get(m)) {
					h = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				if (b > a.get(m) && b < a.get(h)) {
					l = m + 1;
				} else {
					h = m - 1;
				}
			}
		}

		return -1;
	}

	public int sqrt(int a) {
		int l = 0;
		int h = a;
		long t = a < 0 ? a * 1 : a;

		while (l <= h) {

			int m = l + (h - l) / 2;
			long val = m * m;
			if (val >= 0 && val <= t) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		int ret = (int) l - 1;
		if (a < 0) {
			ret *= -1;
		}
		return ret;
	}

	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		ArrayList<Integer> ll = new ArrayList<Integer>();
		ll.add(-1);
		ll.add(-1);
		int l = 0;
		int h = a.size() - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a.get(m) == b) {
				ll.set(0, searchleft(a, l, h, b));
				ll.set(1, searchRight(a, l, h, b));
				break;
			} else if (a.get(m) > b) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return ll;
	}

	private int searchleft(List<Integer> a, int l, int h, int b) {
		int ret = l;
		while (l <= h) {
			int m = l + (h-l)/2;
			if (a.get(m) == b) {
				ret = m;
				h = m-1;
			} else {
				l = m+1;
			}
		}
		return ret;
	}
	

	private int searchRight(List<Integer> a, int l, int h, int b) {
		int ret = l;
		while (l <= h) {
			int m = l + (h-l)/2;
			if (a.get(m) == b) {
				ret = m;
				l = m+1;
			} else {
				h = m-1;
			}
		}
		return ret;
	}

}

