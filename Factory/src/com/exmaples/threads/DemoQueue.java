package com.exmaples.threads;

public class DemoQueue {

	public static void main(String[] args) {
		String s = "name";
		Queue q = new Queue();
		for (int i = 0; i < 10; i++) {
			q.push(s + i);
		}
		while (q.size() > 0) {
			System.out.println(q.pull());
		}
	}
}
