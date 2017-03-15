package test;

import java.util.Arrays;

public class Reverse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 6, 1, 3, 4, 5, 44, 4, 4 };
		test.Sortirovka.sortBubl(a);
		System.out.println(Arrays.toString(a));
		reverse(a);
		System.out.println(Arrays.toString(a));

	}

	public static void reverse(int[] arr) {
		int temp = 0;
		for (int i = 0; i < (arr.length - 1) / 2; i++) {
			temp = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = arr[i];
			arr[i] = temp;
		}
	}
}
