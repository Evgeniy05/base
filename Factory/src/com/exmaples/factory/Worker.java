package com.exmaples.factory;

public class Worker {
	private Engine engine;
	private Body body;
	private Accessory accessory;
	{
		name = Factory.WORKER;
	}

	public Worker() {
		super();
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

	public String getName() {
		return name;
	}

	private String name;

}
