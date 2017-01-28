package com.exmaples.factory;

public class Engine extends Item {

	{
		name = Factory.ENGINE;
	}

	public Engine(Supplier supplier) {
		super(supplier);
	}

	public Engine() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	private String name;
}
