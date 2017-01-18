package com.exmaples.factory;

public class Body extends Item {
	public Body(int id, String name, Supplier supplier, long date) {
		super(id, name, supplier, date);
	}

	String color;
}
