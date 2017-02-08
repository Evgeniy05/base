package com.exmaples.factory;

import java.util.concurrent.ConcurrentHashMap;

public class Place {
	private ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();
	private Engine engine = null;
	private Body body = null;
	private Accessory accessory = null;
	private Worker worker;
	private Auto car;

	public Place(Worker worker) {
		this.worker = worker;
	}

	public boolean check() {
		boolean start = false;
		if (items.size() == 3) {
			start = true;
		}
		return start;

	}

	public Auto createCar() {
		for (String key : items.keySet()) {
			if ("Engine".equals(items.get(key).getName()))
				engine = (Engine) items.get(key);
			if ("Body".equals(items.get(key).getName()))
				body = (Body) items.get(key);
			if ("Accessory".equals(items.get(key).getName()))
				accessory = (Accessory) items.get(key);
		}
		car = worker.createCar(engine, body, accessory);

		return car;
	}

	public Worker getWorker() {
		return worker;
	}

	public ConcurrentHashMap<String, Item> getItems() {
		return items;
	}

}
