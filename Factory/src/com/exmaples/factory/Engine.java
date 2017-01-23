package com.exmaples.factory;

public class Engine extends Item {

	public Engine(Supplier supplier) {
		super(supplier);
		date = super.getDate();
		name = super.ENGINE;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String getDate() {
		return date;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;
	private String name, date;
}
