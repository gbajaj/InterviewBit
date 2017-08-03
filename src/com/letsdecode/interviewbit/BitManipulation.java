package com.letsdecode.interviewbit;

import java.util.List;

public class BitManipulation {
	long[] d = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

	public long reverse(long a) {
		return reverse16(a & 0xFFFF) <<16 | reverse16((a >>> 16) & 0xFFFF);
				
	}

	public long reverse16(long a) {
		return reverse8(a & 0xFF) << 8 | reverse8((a >>> 8) & 0xFF);
	}

	public long reverse8(long a) {
		return reverse4(a & 0xf) << 4 | reverse4((a >>> 4) & 0xf);
	}

	private long reverse4(long i) {
		i = i & 0xf;
		return d[(int) i];
	}
	
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int xor = 0;
	    for (int i = 0; i < a.size(); i++) {
	        xor ^= a.get(i);
	    }
	    return xor;
	}
}
