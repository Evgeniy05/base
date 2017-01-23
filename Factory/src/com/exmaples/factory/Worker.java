package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	public Worker(String name) {
		this.name = name;
		id = 0;
		setId();
	}

	public void addItem(Item item) {
		listItem.add(item);
	}

	public synchronized void createCar(List listItemToCar) throws InterruptedException {
		while (listItemToCar.get(0) == null || listItemToCar.get(1) == null || listItemToCar.get(2) == null)
			wait();
		Auto car = new Auto((Item) listItemToCar.get(0), (Item) listItemToCar.get(1), (Item) listItemToCar.get(2));
		listAuto.add(car);

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
	private List<Item> listItem = new ArrayList<>(3);

}
