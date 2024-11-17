package com.sunbeam;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}
	
	private final int SIZE;
	private Entry arr[];
	
	public HashTable(int size) {
		SIZE = size;
		arr = new Entry[size];
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public int h(int k, int i) {
		return (h(k) + i) % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot for given key
		int slot = h(key);			// hashcode
		int i = 1;
		
		//2. if collision has occured or key already exist
		while(arr[slot] != null) {
			//2.1 check if key alreay exist
			if(key == arr[slot].key) {			// equals
				arr[slot].value = value;
				return;
			}
			//2.2 if collision has occured, do probing
			slot = h(key, i++);
		}
		
		//3. create and store entry at slot
		arr[slot] = new Entry(key, value);
	}
	
	public String get(int key) {
		//1. find slot for given key
		int slot = h(key);
		int i = 1;
		
		//2. search for key
		while(arr[slot] != null) {
			//2.1 check if key present
			if(key == arr[slot].key) {
				return arr[slot].value;
			}
			//2.2 if collision has occured, do probing
			slot = h(key, i++);
		}
		
		//3. key is not found
		return null;
	}
	
}
















