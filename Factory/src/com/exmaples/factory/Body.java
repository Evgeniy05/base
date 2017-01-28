package com.exmaples.factory;

public class Body extends Item {
	{
		name = Factory.BODY;
	}

	public Body(Supplier supplier) {
		super(supplier);
	}

	public Body() {

	}

	@Override
	public String getName() {
		return name;
	}

	private String name;
}
