package com.exmaples.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Storage extends Item {
	private ConcurrentHashMap<String, Item> items;
	private int id;
	private long size;
	private String name, date;
	private Item item;

	public Storage(int size, String name) {
		super(size, name);
		this.name = name;
		this.id = super.getId();
		this.date = super.getDate();
		this.size = size;
		this.setStorage();
	}

	public Storage(String name) {
		super(name);
		this.name = name;
		this.id = super.getId();
		this.date = super.getDate();
		this.name = name;
		this.setStorage();
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public String getName() {
		return name;
	}

	private void setStorage() {
		items = new ConcurrentHashMap<>();
	}

	public ConcurrentHashMap<String, Item> getStorage() {
		return items;
	}

	public long getValue() {
		return items.mappingCount();
	}

	public long getFreeValue() {
		return getSize() - getValue();
	}

	public void addItem(Item item) {
		items.putIfAbsent(item.getDate(), item);
	}

	public Collection<Item> getItems() {
		return items.values();
	}

	public Item getItem(String name) {
		for (String key : items.keySet()) {
			if (items.get(key).getName() == name) {
				item = items.get(key);
				itemRemove(item);
			}
		}
		return item;
	}

	public void itemRemove(Item item) {
		Iterator<Entry<String, Item>> it = items.entrySet().iterator();
		while (it.hasNext()) {
			if (it.next().getValue().getName() == item.getName()) {
				it.remove();
			}
		}

	}
}
