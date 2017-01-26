package com.exmaples.factory;

public class Body extends Item {
	public Body(Supplier supplier) {
		super(supplier);
		id = super.getId();
		name = Factory.getNameBody();
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

	@Override
	public String getName() {
		return name;
	}

	private String color, name, date;
	private int id;

}
