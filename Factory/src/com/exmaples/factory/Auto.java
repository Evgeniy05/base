package com.exmaples.factory;

import java.util.concurrent.ConcurrentHashMap;

public class Auto {
	public Auto(Item engine, Item body, Item accessory) {
		id = 0;
		setId();
		this.engine = engine;
		this.body = body;
		this.accessory = accessory;
		date = "";
		setDate();
		size = Integer.parseInt(Property.getConfig().get(Property.STORAGE_AUTO_SIZE));
		addCar();
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	public void addCar() {
		if (cars.size() >= size) {
			return;
		}
		cars.putIfAbsent(this, getDate());
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

	public String getDate() {
		return date;
	}

	public void setDate() {
		date = engine.getDate() + body.getDate() + accessory.getDate();
	}

	public Auto getCar() {
		if (cars.entrySet().iterator().hasNext() == true) {
			car = cars.entrySet().iterator().next().getKey();
		}
		cars.remove(car);
		return car;
	}

	private int id, size;
	private String date;
	private Item engine, body, accessory;
	private static int nextId = 1;
	public static ConcurrentHashMap<Auto, String> cars = new ConcurrentHashMap<>();
	private Auto car;
}
