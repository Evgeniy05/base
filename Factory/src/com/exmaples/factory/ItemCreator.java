package com.exmaples.factory;

import java.util.concurrent.Callable;

public class ItemCreator implements Callable<Item> {

	// private long speed;
	private String name;
	private Item item;

	public ItemCreator(String name) {
		this.name = name;
	}

	@Override
	public Item call() throws InterruptedException {

		return create(name);
	}

	public Item create(String aName) throws InterruptedException {
		switch (aName) {
		case Item.ENGINE:
			item = new Engine();
			break;
		case Item.BODY:
			item = new Body();
			break;
		case Item.ACCESSORY:
			item = new Accessory();
			break;
		}
		// Thread.sleep(speed);
		return item;
	}
}

// public class ItemCreator implements Callable<ConcurrentHashMap<String, Item>>
// {
//
// private long speed;
// private ConcurrentHashMap<String, Item> items;
//
// public ItemCreator(long aSpeed, ConcurrentHashMap<String, Item> aItems) {
// speed = aSpeed;
// items = aItems;
// }
//
// @Override
// public ConcurrentHashMap<String, Item> call() throws InterruptedException {
//
// return create(speed);
// }
//
// public ConcurrentHashMap<String, Item> create(long speed) throws
// InterruptedException {
// int countEngine = 0;
// int countBody = 0;
// int countAccessory = 0;
// int kSuppliersEngine =
// Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
// int kSuppliersBody =
// Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
// int kSuppliersAccessory =
// Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
// while (countEngine < kSuppliersEngine) {
// items.putIfAbsent(Factory.ENGINE, (new Engine()));
// countEngine++;
// }
// while (countBody < kSuppliersBody) {
// items.putIfAbsent(Factory.BODY, (new Body()));
// }
// while (countAccessory < kSuppliersAccessory) {
// items.putIfAbsent(Factory.ACCESSORY, (new Accessory()));
// }
// countAccessory++;
// Thread.sleep(speed);
// return items;
// }
// }
