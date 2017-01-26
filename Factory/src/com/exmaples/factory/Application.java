package com.exmaples.factory;

public class Application {

	public static void main(String[] args) {
		Factory factory = new Factory();
		System.out.println(factory.worker.getStorage().getValue());
		System.out.println(factory.worker.getStorage().getValue());
	}

}
