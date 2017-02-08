package com.exmaples.factory;

public class AccessoryCreator extends ItemCreator<Accessory> {

	public AccessoryCreator(String name) {
		super(name);

	}

	@Override
	public Accessory create() {
		Accessory accessory = new Accessory(super.getName(), super.generateId());
		return accessory;
	}
}
