package com.sunbeam;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Program03 {

	public static void main(String[] args) {
		Stream.of(9, 2, 5, 1, 8, 3, 6, 4, 7).filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				System.out.println("Inside Filter - " + t);
				return t % 2 == 0;
			}
		}).sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println("Inside Sorted " + o1 + "," + o2);
				return o1 - o2;
			}
		}).forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("Inside For-Each - " + t);
			}
		});

	}

}
