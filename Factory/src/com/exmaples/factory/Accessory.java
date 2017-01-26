package com.exmaples.factory;

public class Accessory extends Item {
	public Accessory(Supplier supplier) {
		super(supplier);
		name = Factory.getNameAccessory();
		id = super.getId();
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price, id;
	private String name, date;
}
