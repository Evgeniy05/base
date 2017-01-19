package com.exmaples.factory;

public class Auto {
	public Auto(int id, Item engine, Item body, Item accessory) {
		this.id = id;
		this.engine = engine;
		this.body = body;
		this.accessory = accessory;
	}

	public int getId() {
		return id;
	}

	public Item getEngine() {
		return engine;
	}

	public Item getBody() {
		return body;
	}

	public Item getAccessory() {
		return accessory;
	}

	private int id;
	private Item engine, body, accessory;

}
