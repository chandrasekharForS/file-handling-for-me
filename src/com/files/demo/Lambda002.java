package com.files.demo;

import java.util.function.Function;

public class Lambda002 {

	public static void main(String[] args) {
		Function<Integer, Integer> square = x -> x * x;
		System.out.println(square.apply(10));

	}
}
