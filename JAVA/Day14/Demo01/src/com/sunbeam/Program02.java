package com.sunbeam;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Program02 {

	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 10).filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				System.out.println("Inside Filter - " + t);
				return t % 2 == 0;
			}
		}).forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("Inside For-Each - " + t);
			}
		});

	}

}
