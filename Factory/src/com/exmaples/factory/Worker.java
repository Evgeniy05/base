package com.exmaples.factory;

public class Worker {
	private Order order = new Order("", 0);

	{
		name = Factory.WORKER;
	}

	public Worker() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	private String name;
	private Auto car;

	public Auto createCar(Engine engine, Body body, Accessory accessory) {
		car = new Auto(engine, body, accessory);
		return car;
	}
}