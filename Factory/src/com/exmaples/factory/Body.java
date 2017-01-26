package com.exmaples.factory;

public class Body extends Item {
	public Body(Supplier supplier) {
		super(supplier);
		this.id = super.getId();
		this.name = Factory.getNameBody();
		this.date = super.getDate();
	}

	public Body() {
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

	private String color, name, date;
	private int id;
	private Supplier supplier;

}
