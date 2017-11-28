package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BitManipulation {
	long[] d = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

	public long reverse(long a) {
		return reverse16(a & 0xFFFF) << 16 | reverse16((a >>> 16) & 0xFFFF);

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

	int dic[] = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
	int wordSize = 4;
	int byteMask = 0x0000000F;

	public int numSetBits(long a) {
		return dic[(byte) (a & byteMask)]
				+ dic[(byte) (a >>> wordSize) & byteMask]
				+ dic[(byte) (a >>> (2 * wordSize)) & byteMask]
				+ dic[(byte) (a >>> (3 * wordSize)) & byteMask]
				+ dic[(byte) (a >>> (4 * wordSize)) & byteMask]
				+ dic[(byte) (a >>> (5 * wordSize)) & byteMask]
				+ dic[(byte) (a >>> (6 * wordSize)) & byteMask]
				+ dic[(byte) (a >>> (7 * wordSize)) & byteMask];
	}

	public int findMinXor(ArrayList<Integer> A) {
		if (A.isEmpty()) return 0;
		if (A.size() == 1) return A.get(0);
		int min = Integer.MAX_VALUE;
		Collections.sort(A);
		
		for (int i = 1;i < A.size(); i++) {
			min = Math.min(min, A.get(i-1) ^A.get(i));
		}
		return min;

	}
	
    public int findMaximumXOR(int[] a) {
        Arrays.sort(a);
		int i = 0 ; 
        int j = a.length-1;
        int min = 0;
        while (i < j) {
			if ((a[i] ^ a[j])> min) {
                min = (a[i] ^ a[j]);
            } 
			if ((a[i+1] ^ a[j]) > (a[i] ^ a[j-1])) {
                i++;
            } else {
 	           j--;
            }
        }
        return min;
    }
    public int divide(int dividend, int divisor) {
        long dend  = Math.abs((long)dividend);
        long dsor  = Math.abs((long)divisor);
        long ans = 0;
        while (dsor <= dend) {
            long a = dsor;
            long m = 1;
            while ((a << 1) <= dend ) {
                a<<=1;
                m<<=1;
            }
            ans += m;
            dend -= a;
        }
                      
        if ((dividend < 0 && divisor > 0) ||
           (dividend >= 0 && divisor < 0)) {
            if (ans >= ((long)Integer.MAX_VALUE+1)) {
                return Integer.MIN_VALUE;
            }
            return (int)-(ans);
        }
        if (ans >= (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans;
    }
    
    int a[] = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    
    public int hammingDistance(int x, int y) {
        int res = x^y;
        return hammingDistance16(res) + hammingDistance16(res >>> 16);
    }

    private int hammingDistance16(int x) {
        return hammingDistance8(x) + hammingDistance8(x >>> 8);
    }
    
    private int hammingDistance8(int x) {
        return a[x & 0xF] + a[(x>>4) & 0xf];
    }
}