package com.letsdecode.interviewbit;

import java.util.HashMap;

public class LRUCache {
//	/**
//	 * Pre Work
//	 * @author gauravb
//	 *
//	 */
//	class Node{
//	    int key;
//	    int value;
//	    Node pre;
//	    Node next;
//	 
//	    public Node(int key, int value){
//	        this.key = key;
//	        this.value = value;
//	    }
//	}
//	int capacity;
//    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
//    Node head=null;
//    Node end=null;
// 
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
// 
//    public int get(int key) {
//        if(map.containsKey(key)){
//            Node n = map.get(key);
//            remove(n);
//            setHead(n);
//            return n.value;
//        }
// 
//        return -1;
//    }
// 
//    public void remove(Node n){
//        if(n.pre!=null){
//            n.pre.next = n.next;
//        }else{
//            head = n.next;
//        }
// 
//        if(n.next!=null){
//            n.next.pre = n.pre;
//        }else{
//            end = n.pre;
//        }
// 
//    }
// 
//    public void setHead(Node n){
//        n.next = head;
//        n.pre = null;
// 
//        if(head!=null)
//            head.pre = n;
// 
//        head = n;
// 
//        if(end ==null)
//            end = head;
//    }
// 
//    public void set(int key, int value) {
//        if(map.containsKey(key)){
//            Node old = map.get(key);
//            old.value = value;
//            remove(old);
//            setHead(old);
//        }else{
//            Node created = new Node(key, value);
//            if(map.size()>=capacity){
//                map.remove(end.key);
//                remove(end);
//                setHead(created);
// 
//            }else{
//                setHead(created);
//            }    
// 
//            map.put(key, created);
//        }
//    }
	
	    class Node {
	        Node pre;
	        Node next;
	        int value;
	        int key;
	        public Node(int key, int v) {
	            this.key = key;
	            value = v;
	        }
	    }
	    Node head;
	    Node tail;
	    HashMap<Integer, Node> map = new HashMap<>();
	    int MAX = 0;
	    public LRUCache(int capacity) {
	        MAX = capacity;
	        head = null;
	        tail = null;
	    }
	    private void print () {
	        System.out.println("");
	        Node c = head;
	        while (c != null) {
	             System.out.print( c.value + " ");
	            c = c.next;
	        }
	        System.out.println("");
	    }
	    public int get(int key) {
	        System.out.println("get " + key);
	        Node n = remove(key);
	        if (n != null) {
	            add(key, new Node(key, n.value));
	            print();
	            return n.value;
	        }
	        print();
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	        System.out.println("put " + key);
	        if (map.containsKey(key) == false && map.size() >= MAX) {
	             System.out.println("call remove max" + tail.key );
	             remove(tail.key);
	        } else {
	            System.out.println("call remove "  +key);
	            Node t = remove(key);
	        }
	        add(key, new Node(key, value));
	        print();
	    }
	    
	    private void add(int key, Node w) {
	        if (head == null) {
	            head = tail = w;
	        } else {
	            w.next= head;
	            head.pre = w;
	            head = w;
	        }
	        
	        map.put(key, w);
	    }
	    
	    private Node remove(int key) {
	        if (map.containsKey(key) == false) return null;
	        
	        Node n = map.get(key);
	        System.out.println("found node to remove" + n.key);
	        Node pre = n.pre;
	        Node next = n.next;
	        if (pre != null) {
	            pre.next = next;
	        } else head = next;
	        
	        if (next != null) {
	            next.pre = pre;
	        } else tail = pre;
	        print();
	        // System.out.println("head " + head.value);
	        // System.out.println("tail " + tail.value);
	        Node ret = map.remove(key);
	        
	        return ret;
	    }
	    
}
