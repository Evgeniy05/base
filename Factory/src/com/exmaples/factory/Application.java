package com.exmaples.factory;

public class Application {
	public static void main(String[] args) {
		Property s = new Property();

		System.out.println(s.getConfig().get(s.STORAGE_ACCESSORY_SIZE));
		System.out.println(s.getClass().getSimpleName());
	}
}
