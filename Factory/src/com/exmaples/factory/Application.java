package com.exmaples.factory;

public class Application {
	public static void main(String[] args) {

		System.out.println(Property.getConfig().get(Property.DEALERS));
	}
}
