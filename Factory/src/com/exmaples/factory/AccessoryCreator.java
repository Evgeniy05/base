package com.exmaples.factory;

public class AccessoryCreator extends ItemCreator<Accessory> {
	private String name;

	public AccessoryCreator(String name) {
		super(name);

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Accessory create() {
		Accessory accessory = new Accessory(super.getName(), super.generateId());
		return accessory;
	}
}
