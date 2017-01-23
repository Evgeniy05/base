package com.exmaples.factory;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
	private ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();
	private int size, id;
	private String name;
	private static int nextId = 1;
	private Item item;

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
		items.putIfAbsent(item.getDate(), item);
	}

	public Collection<Item> getItems() {
		return items.values();
	}

	public Item getItem() {
		if (items.entrySet().iterator().hasNext() == true) {
			item = items.entrySet().iterator().next().getValue();
			items.remove(item);
		}
		return item;
	}
}
