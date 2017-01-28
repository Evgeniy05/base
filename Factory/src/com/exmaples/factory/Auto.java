package com.exmaples.factory;

public class Auto extends Item {
	{
		name = super.getName() + String.valueOf(super.getId());
	}

	public Auto() {

	}

	public Auto(Engine engine, Body body, Accessory accessory) {
		super(engine, body, accessory);
		setStorage(name);
	}

	@Override
	public String getName() {
		return name;
	}

	private void setStorage(String name) {
		storage = new Storage(name);

	}

	public Storage getStorage() {
		return storage;
	}

	private String name;
	private Storage storage;
}
