package com.exmaples.factory;

public class Worker extends Storage {
	{
		name = Factory.WORKER + String.valueOf(super.getId());
	}

	public Worker() {
		super();
	}

	@Override
	public String getName() {
		return name;
	}

	private String name;

}
