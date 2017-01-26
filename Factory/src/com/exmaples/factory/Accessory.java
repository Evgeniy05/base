package com.exmaples.factory;

public class Accessory extends Item {
	public Accessory(Supplier supplier) {
		super(supplier);
		name = Factory.getNameAccessory();
		id = super.getId();
		date = super.getDate();

	}

	public Accessory() {
		super();
		this.id = super.getId();
		this.date = super.getDate();
		this.name = Factory.getNameEngine();
		this.supplier = null;
	}

	@Override
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
	private Supplier supplier;
}
