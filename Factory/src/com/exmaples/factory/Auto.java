package com.exmaples.factory;

public class Auto extends Item {
	private String name;
	private Engine engine;
	private Body body;
	private Accessory accessory;
	private int id;
	public static final String AUTO = "Auto";

	public Auto(Engine engine, Body body, Accessory accessory) {
		this.name = AUTO + "Car";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Engine getEngine() {
		return engine;
	}

	public Body getBody() {
		return body;
	}

	public Accessory getAccessory() {
		return accessory;
	}

}
