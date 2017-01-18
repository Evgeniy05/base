package com.exmaples.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
	private Map<Integer, Item> items = new HashMap<>();
	private int size;
	private String id;

	public Warehouse(int size, String id) {
		this.size = size;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public void addItem(Item item) {
		if (items.size() >= size) {
			return;
		}
		items.put(item.getId(), item);
	}

	public Collection<Item> getItems() {
		return items.values();
	}
}
