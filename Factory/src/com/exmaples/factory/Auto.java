package com.exmaples.factory;

public class Auto extends Item {
	private String name;
	private Engine engine = new Engine("", 0);
	private Body body = new Body("", 0);
	private Accessory accessory = new Accessory("", 0);
	private int id = 0;
	private static int nextId = 1;
	public static final String AUTO = "Auto";

	{
		id = nextId;
		nextId++;
	}

	public Auto(Engine engine, Body body, Accessory accessory) {
		this.name = AUTO + "Car";
		this.engine = engine;
		this.body = body;
		this.accessory = accessory;

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
