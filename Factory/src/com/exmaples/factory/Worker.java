package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	public Worker(int id) {
		this.id = id;
	}

	public Auto createCar() {
		int idAuto = 1;
		Auto car = new Auto(idAuto, engine, body, accessory);
		idAuto = nextIdAuto;
		nextIdAuto++;
		return car;

	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = nextId;
		nextId++;
	}

	private int id;
	private List<Item> listItem = new ArrayList<>(3);
	private static int nextId = 1;
	private static int nextIdAuto = 1;
	private Item engine, body, accessory;
}
