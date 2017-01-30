package com.exmaples.factory;

import java.util.Iterator;
import java.util.Map.Entry;

public class Dealer extends Auto {
	{
		name = Factory.DEALER + String.valueOf(super.getId());
	}

	public Dealer() {
		super();

	}

	@Override
	public String getName() {
		return name;
	}

	public long getValueCar() {
		return storage.getValue();
	}

	public void sail() {

		Iterator<Entry<Integer, Item>> it = super.getStorage().getStorage().entrySet().iterator();
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

	private int result;
	private String name;
	private Storage storage;

}
