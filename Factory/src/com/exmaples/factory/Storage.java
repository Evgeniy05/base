package com.exmaples.factory;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class Storage<T extends Item> {

	private ConcurrentHashMap<Integer, T> items = new ConcurrentHashMap<>();
	private final Integer size;
	private String name;

	public Storage(Integer size, String name) {
		this.size = size;
		this.name = name;

	}

	public Collection<T> getItemList() {
		return items.values();
	}

	public Storage(Integer size) {
		this.size = size;
	}

	public void addItem(T item) {

		items.put(item.getId(), item);

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

	public T getItem() {
		T item = null;
		Integer id = items.keys().nextElement();
		item = items.get(id);
		items.remove(id);

		return item;
	}

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return (int) items.mappingCount();
	}

}
