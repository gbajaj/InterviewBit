package com.letsdecode.interviewbit;

public class StringsWeekOne {

	/**
	 * Roman to Integer - Week 1 Assignment -Strings
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInteger(String s) {
		if (s == null || s.trim().isEmpty()) {
			return 0;
		}
		int val = getVal(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			int cur = getVal(s.charAt(i));
			if (cur >= getVal(s.charAt(i + 1))) {
				val += cur;
			} else {
				val -= cur;
			}
		}
		return val;
	}

	int getVal(Character c) {
		Character cc = Character.toUpperCase(c);
		switch (cc) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;

	}

	/**
	 * Compare Version - Week 1 Assignment - Strings
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int compareVersion(String a, String b) {
		int ret = 0;
		a = a.trim();
		b = b.trim();
		String[] as = a.split("\\.");
		String[] bs = b.split("\\.");
		int i = 0;
		for (i = 0; i < as.length && i < bs.length; i++) {

			int diff = compare(as[i], bs[i]);
			if (diff == 0)
				continue;
			return diff;
		}

		if (i < as.length) {
			for (; i < as.length; i++) {
				Long temp = Long.parseLong(as[i]);
				if (temp.intValue() > 0) {
					return 1;
				}
			}
		}
		if (i < bs.length) {
			for (; i < bs.length; i++) {
				Long temp = Long.parseLong(bs[i]);
				if (temp.intValue() > 0) {
					return -1;
				}
			}
		}

		return ret;
	}

	int compare(String s, String t) {

		char a[] = s.toCharArray();
		char b[] = t.toCharArray();
		int i = 0;
		int j = 0;
		while (i < a.length) {
			if (Integer.parseInt("" + a[i]) == 0) {
				i++;
			} else
				break;
		}
		while (j < b.length) {
			if (Integer.parseInt("" + b[j]) == 0) {
				j++;
			} else
				break;
		}

		if ((a.length - i) != (b.length - j)) {
			return (a.length - i) > (b.length - j) ? 1 : -1;
		}
		for (; i < a.length && j < b.length; i++, j++) {
			if (Integer.parseInt("" + a[i]) != Integer.parseInt("" + b[j])) {
				if (Integer.parseInt("" + a[i]) < Integer.parseInt("" + b[j])) {
					return -1;
				}
				return 1;
			}
		}
		return 0;

	}
}
