package com.exmaples.factory;

public class Engine extends Item {

	{
		name = super.ENGINE;
	}

	public Engine() {
		super();
	}

	public String getName() {
		return name;
	}

	private String name;
}
