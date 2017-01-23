package com.exmaples.factory;

public class Body extends Item {
	public Body(Supplier supplier) {
		super(supplier);
		id = super.getId();
		name = super.BODY;
		date = super.getDate();
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDate() {
		return date;
	}

	String color, name, date;
	int id;
}
