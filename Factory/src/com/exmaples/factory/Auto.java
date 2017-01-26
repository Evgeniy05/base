package com.exmaples.factory;

public class Auto extends Item {
	public Auto(Engine engine, Body body, Accessory accessory) {
		super(engine, body, accessory);
		this.engine = engine;
		this.body = body;
		this.accessory = accessory;
		name = super.getName();
		id = super.getId();
		date = super.getDate();
		setStorage(name);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}

	@Override
	public Body getBody() {
		return body;
	}

	@Override
	public Accessory getAccessory() {
		return accessory;
	}

	@Override
	public String getDate() {
		return date;
	}

	private void setStorage(String name) {
		storage = new Storage(name);

	}

	public Storage getStorage() {
		return storage;
	}

	private int id;
	private String date, name;
	private Engine engine;
	private Body body;
	private Accessory accessory;
	private Storage storage;
}
