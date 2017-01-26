package com.exmaples.factory;

public class Worker extends Item {
	public Worker() {
		super();
		this.name = Factory.getNameWorker();
		id = super.getId();
		date = super.getDate();
		setStorage(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDate() {
		return date;
	}

	private void setStorage(String name) {
		storage = new Storage(name);
	}

	public Storage getStorage() {
		return storage;
	}

	private int id;
	private String name, date, itemDate;
	private Storage storage;
	private Engine engine;
	private Body body;
	private Accessory accessory;
}
