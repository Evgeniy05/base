package com.exmaples.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	private Map<String, Item> items = new HashMap<>();
	private int size, id;
	private String name;
	private static int nextId = 1;

	public Storage(int size, String name) {
		this.size = size;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void addItem(Item item) {
		if (items.size() >= size) {
			return;
		}
		items.put(item.getDate(), item);
	}

	public Collection<Item> getItems() {
		return items.values();
	}
}
