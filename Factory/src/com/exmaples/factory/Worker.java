package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	public Worker(String name) {
		this.name = name;
		id = 0;
		setId();
	}

	public Auto createCar(Item engine, Item body, Item accessory) {
		Auto car = new Auto(engine, body, accessory);
		listAuto.add(car);
		return car;

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	private int id;
	private String name;
	private static List<Auto> listAuto = new ArrayList<>();
	private static int nextId = 1;

}
