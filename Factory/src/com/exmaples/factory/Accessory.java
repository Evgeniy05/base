package com.exmaples.factory;

public class Accessory extends Item {
	{
		name = Factory.ACCESSORY + String.valueOf(super.getId());

	}

	public Accessory(Supplier supplier) {
		super(supplier);

	}

	public Accessory() {

	}

	@Override
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price;
	private String name;
}
