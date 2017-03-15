package test;

import java.util.Arrays;

public class Sortirovka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 6, 1, 3, 4, 5, 44, 4, 4 };
		int[] b = { 5, 6, 1, 3, 4, 5, 44, 4, 4 };
		sortBubl(a);
		sortVstavka(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	public static void sortVstavka(int[] arr) {
		int temp = 0;
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				temp = arr[i + 1];
				arr[i + 1] = arr[i];
				j = i;
				while (j > 0 && temp < arr[j - 1]) {
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = temp;
			}
		}
	}

	public static void sortBubl(int[] arr) {
		for (int min = 0; min < arr.length - 1; min++) {
			int least = min;
			for (int j = min + 1; j < arr.length; j++) {
				if (arr[j] < arr[least]) {
					least = j;
				}
			}
			int tmp = arr[min];
			arr[min] = arr[least];
			arr[least] = tmp;
		}
	}
}
