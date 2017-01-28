package com.exmaples.factory;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Storage extends Item {
	private ConcurrentHashMap<Integer, Item> items;
	private Auto auto;
	private Engine engine;
	private Body body;
	private Item item;
	private Accessory accessory;
	public int result = 0;
	{
		items = new ConcurrentHashMap<>();
	}

	public Storage(int aSize, String aName) {
		super(aSize, aName);
	}

	public Storage(String aName) {
		super(aName);
	}

	public Storage() {
		this("Storage#");
	}

	public ConcurrentHashMap<Integer, Item> getStorage() {
		return items;
	}

	public long getValue() {
		return items.mappingCount();
	}

	public long getFreeValue() {
		return getSize() - getValue();
	}

	public void addItem(Item item) {
		// if (item == null) {
		// return;
		// }
		items.putIfAbsent(item.getId(), item);
	}

	public Item getItem(String name) {
		switch (name) {
		case Factory.ACCESSORY:
			item = getAccessory();
			break;
		case Factory.AUTO:
			item = getAuto();
			break;
		case Factory.BODY:
			item = getBody();
		case Factory.ENGINE:
			item = getEngine();
		}
		return item;
	}

	public Auto getAuto() {
		Iterator<Entry<Integer, Item>> it = items.entrySet().iterator();
		if (it.hasNext()) {
			auto = (Auto) it.next().getValue();
		}
		itemRemove(auto);
		return auto;
	}

	@Override
	public Body getBody() {
		Iterator<Entry<Integer, Item>> it = items.entrySet().iterator();
		if (it.hasNext()) {
			body = (Body) it.next().getValue();
		}
		itemRemove(body);
		return body;
	}

	@Override
	public Engine getEngine() {
		Iterator<Entry<Integer, Item>> it = items.entrySet().iterator();
		if (it.hasNext()) {
			engine = (Engine) it.next().getValue();
		}
		itemRemove(engine);
		return engine;
	}

	@Override
	public Accessory getAccessory() {
		Iterator<Entry<Integer, Item>> it = items.entrySet().iterator();
		if (it.hasNext()) {

			accessory = (Accessory) it.next().getValue();
		}

		itemRemove(accessory);
		return accessory;
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

	public void itemRemove() {
		Iterator it = items.entrySet().iterator();
		if (it.hasNext()) {
			Entry item = (Entry) it.next();
			it.remove(item);
		}
	}

}
