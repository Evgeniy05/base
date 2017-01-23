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

	public int getFreeValue() {
		return size - items.size();
	}

	public synchronized void addItem(Item item) throws InterruptedException {
		while (items.size() == size) {
			wait();
		}
		items.putIfAbsent(item.getDate(), item);
		notifyAll();
	}

	public Collection<Item> getItems() {
		return items.values();
	}

	public Item getItem(Item item) {
		items.remove(item);
		return item;
	}
}
