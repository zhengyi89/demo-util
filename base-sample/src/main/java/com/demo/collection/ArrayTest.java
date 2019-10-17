package com.demo.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class ArrayTest {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		Iterator<String> it = c.iterator();
		c.add("a");
		String s = it.next();
		System.out.println(s);
		
	}
}

class CompareTest implements Comparable<List>{

	@Override
	public int compareTo(List o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


