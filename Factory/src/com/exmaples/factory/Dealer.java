package com.exmaples.factory;

public class Dealer extends Item {
	public Dealer() {
		super();
		this.name = Factory.getNameDealer();
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

	public long getValueCar() {
		return storage.getValue();
	}

	private void setStorage(String name) {
		storage = new Storage(name);

	}

	public Storage getStorage() {
		return storage;
	}

	private int id;
	private String name, date;
	private Storage storage;

}
