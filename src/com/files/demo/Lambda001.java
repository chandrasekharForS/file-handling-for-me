package com.files.demo;

@FunctionalInterface
interface Sum {
    int add(int x, int y);
}



public class Lambda001 {

	public static void main(String[] args) {
		Sum sum = (x, y) -> x + y;
		System.out.println(sum.add(10, 20));
	}

}
