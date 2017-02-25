package com.exmaples.factory;

public class Worker // implements Callable<Auto>
{
	private String name;
	private Auto car;
	private Engine engine = null;
	private Body body = null;
	private Accessory accessory = null;
	private boolean status = false;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	{
		name = Factory.WORKER;
	}

	public Worker() {
	}

	public String getName() {
		return name;
	}

	public Auto createCar() {
		if (engine == null || body == null || accessory == null) {
			System.out.println("Error");
			car = null;
		} else {
			car = new Auto(engine, body, accessory);
			System.out.println(car.getName() + " " + car.getId());
		}
		return car;
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

	// @Override
	// public Auto call() throws Exception {
	//
	// return createCar();
	// }
}