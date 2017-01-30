package com.exmaples.factory;

public class Accessory extends Item {
	{
		name = super.ACCESSORY;

	}

	public Accessory() {

	}

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
