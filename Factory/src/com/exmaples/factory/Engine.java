package com.exmaples.factory;

public class Engine extends Item {

	public Engine(Supplier supplier) {
		super(supplier);
		id = super.getId();
		date = super.getDate();
		name = Factory.getNameEngine();

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDate() {
		return date;
	}

	private int value, id;
	private String name, date;

}
