package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void test() {
//		LRUCache lruCache = new LRUCache(1);
//		5 1 S 2 1 G 2 S 3 2 G 2 G 3
//		lruCache.set(2,  1);
//		System.out.println(lruCache.get(2));
//		lruCache.set(3,  2);
//		System.out.println(lruCache.get(2));
//		System.out.println(lruCache.get(3));
//		6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(2,  1);
		lruCache.set(1,  1);
		lruCache.set(2,  3);
		lruCache.set(4,  1);
		
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
		
	}

}
