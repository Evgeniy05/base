package com.exmaples.factory;

public class Engine extends Item {

	public Engine(Supplier supplier) {
		super(supplier);
		id = super.getId();
		date = super.getDate();
		name = Factory.getNameEngine();

	}

	public Engine() {
		super();
		this.name = Factory.getNameEngine();
		this.id = super.getId();
		this.date = super.getDate();
		this.supplier = null;
	}

	@Override
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
	private Supplier supplier;

}
