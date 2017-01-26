package com.exmaples.factory;

import java.util.Iterator;
import java.util.Map.Entry;

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

	public void sail() {

		Iterator<Entry<String, Item>> it = getStorage().getStorage().entrySet().iterator();
		while (it.hasNext()) {
			if (it.next() != null) {
				it.remove();
				result++;
			}
		}
	}

	public int getResultSails() {
		return result;
	}

	private int id, result;
	private String name, date;
	private Storage storage;

}
