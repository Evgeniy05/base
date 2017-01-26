package com.exmaples.factory;

public class Supplier extends Item {
	public Supplier(String name) {
		super(name);
		this.name = name;
		id = super.getId();
		date = super.getDate();
		setStorage(name);

	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
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

	private String name, date;
	private int id;
	private Storage storage;
}
