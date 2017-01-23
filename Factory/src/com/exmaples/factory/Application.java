package com.exmaples.factory;

public class Application {
	public static void main(String[] args) {

		Accessory a = new Accessory(new Supplier("BODY"));
		Accessory b = new Accessory(new Supplier("B"));
		Accessory c = new Accessory(new Supplier("BY"));

		Body d1 = new Body(new Supplier("Body"));
		Body d2 = new Body(new Supplier("Body"));
		System.out.println(a.getDate());
		System.out.println(b.getDate());
		System.out.println(c.getDate());
		System.out.println(d1.getDate());
		System.out.println(d2.getDate());

	}
}
