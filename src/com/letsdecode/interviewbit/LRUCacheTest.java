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
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		
	}

}
