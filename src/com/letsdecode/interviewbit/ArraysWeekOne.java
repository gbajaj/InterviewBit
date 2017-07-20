package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysWeekOne {
	/**
	 * Find Duplicate in Array - Week 1 - Assigment
	 * 
	 * @param a
	 * @return
	 */
	public int repeatedNumber(final List<Integer> a) {
		Collections.sort(a);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).equals(a.get(i - 1))) {
				return a.get(i);
			}
		}
		return -1;
	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a.size() == 0) return;
        int rows[] = new int [a.size()];
        Arrays.fill(rows, 1);
        int col[] = new int [a.get(0).size()];
        Arrays.fill(col, 1);
        for (int i = 0;i<a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rows[i] = 0;
                    col[j] = 0;
                }
            }
        }
        
        for (int j = 0; j<col.length; j++) {
            if (col[j] == 0) {
                for (int i =0 ;i < rows.length; i++) {
                    a.get(i).set(j, 0);
                }
            }
        }
        for (int i = 0; i<rows.length; i++) {
            if (rows[i] == 0) {
                for (int j =0 ;j < col.length; j++) {
                	 a.get(i).set(j, 0);
                }
            }
        }
	}
}
