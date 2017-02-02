package com.exmaples.factory;

public class Accessory extends Item {
	private int price;

	public Accessory(String name, Integer id) {
		super(name, id);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
