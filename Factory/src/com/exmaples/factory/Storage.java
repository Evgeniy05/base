package com.exmaples.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage<T extends Item> {
	private int product = 0;
	private int sail = 0;
	private ConcurrentHashMap<Integer, T> items = new ConcurrentHashMap<>();
	private Integer size;
	private String name;
	private Map<Integer, Integer> sails = new HashMap<>();

	public Storage(Integer size, String name) {
		this.size = size;
		this.name = name;

	}

	public int getResults() {
		return sail;
	}

	public Collection<T> getItemList() {
		return items.values();
	}

	public Storage(Integer size) {
		this.size = size;
	}

	public synchronized void addItem(T item) throws InterruptedException {
		if (getValue() >= size) {
			wait();
		}
		items.put(item.getId(), item);
		if (item.getName().equals(Auto.AUTO + "Car"))
			product++;
		notifyAll();
	}

	public Integer getSize() {
		return this.size;
	}

	public Integer getFreeSpace() {
		return this.size - getValue();
	}

	public void removeItemById(Integer id) {
		this.items.remove(id);
	}

	public synchronized T getItem() throws InterruptedException {
		T item = null;
		while (items.size() == 0)
			wait();
		Integer id = items.keys().nextElement();
		item = items.get(id);
		if (item.getName().equals(Auto.AUTO + "Car"))
			items.remove(id);
		notifyAll();

		return item;
	}

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return (int) items.mappingCount();
	}

}
