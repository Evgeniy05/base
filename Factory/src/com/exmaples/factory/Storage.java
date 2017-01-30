package com.exmaples.factory;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
	private ConcurrentHashMap<Integer, Item> items;
	private Item item;
	private int size;
	private String name;

	{
		items = new ConcurrentHashMap<>();
	}

	public Storage(int size, String name) {
		this.size = size;
		this.name = name;

	}

	public Storage(String name) {
		this.name = name;
	}

	public Storage() {
		this("Storage#");
	}

	public ConcurrentHashMap<Integer, Item> getStorage() {
		return items;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public long getValue() {
		return items.mappingCount();
	}

	public long getFreeValue() {
		return getSize() - getValue();
	}

	public synchronized void addItem(Item item) throws InterruptedException {
		while (getFreeValue() == 0) {
			wait();
		}
		items.putIfAbsent(item.getId(), item);
		notifyAll();
	}

	public void itemRemove(Item item) {
		Iterator<Entry<Integer, Item>> it = items.entrySet().iterator();
		while (it.hasNext()) {
			int id = it.next().getValue().getId();
			if (id == item.getId()) {
				it.remove();
			}
		}

	}

	public synchronized Item getItem(String type) throws InterruptedException {
		while (getValue() == 0) {
			wait();
		}
		for (int key : items.keySet()) {
			if (items.get(key).getClass().getSimpleName().equals(type)) {
				item = items.get(key);

				break;
			}
		}
		itemRemove(item);
		notifyAll();
		return item;

	}
}
