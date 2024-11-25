package com.sunbeam;

public class Main {

	public static void main(String[] args) {
		
		HashTable tbl = new HashTable(10);
		
		tbl.put(8, "v1");
		tbl.put(3, "v2");
		tbl.put(10, "v3");
		tbl.put(4, "v4");
		tbl.put(6, "v5");
		tbl.put(13, "v6");
		tbl.put(23, "v7");
		tbl.put(26, "v8");
		tbl.put(10, "updated");
		
		String value = tbl.search(23);
		if(value == null)
			System.out.println("Key is not found");
		else
			System.out.println("key is found and value : " + value);
		

	}

}
