package com.exmaples.factory;

public class Accessory extends Item {
	public Accessory(int id, String name, Supplier supplier, long date) {
		super(id, name, supplier, date);

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price;

}
