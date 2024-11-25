package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

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
	private List<Entry> arr[];
	
	public HashTable(int size) {
		SIZE = size;
		arr = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			arr[i] = new LinkedList<HashTable.Entry>();
	}
	
	public int h(int k) {
		return k % SIZE;			
	}
	
	public void put(int key, String value) {
		//1. find slot of key
		int slot = h(key);
		
		//2. if key already exist, then update its value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(key == e.key) {
					e.value = value;
					return;
				}
			}
		}
		
		//3. add entry on slot
		Entry e = new Entry(key, value);
		arr[slot].add(e);
	}
	
	public String search(int key) {
		//1. find slot of key
		int slot = h(key);
		
		//2. if key already exist, then update its value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(key == e.key) {
					return e.value;
				}
			}
		}
		
		//3. key is not found
		return null;
	}
}










