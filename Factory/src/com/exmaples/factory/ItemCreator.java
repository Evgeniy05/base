package com.exmaples.factory;

import java.util.concurrent.Callable;

public class ItemCreator implements Callable<Items> {

	private long speed;

	public ItemCreator() {
	}

	@Override
	public Items call() throws InterruptedException {

		return create(speed);
	}

	public Items create(long speed) throws InterruptedException {
		int countEngine = 0;
		int countBody = 0;
		int countAccessory = 0;
		int kSuppliersEngine = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
		int kSuppliersBody = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
		int kSuppliersAccessory = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
		while (countEngine < kSuppliersEngine) {
			Factory.items.getEngineStorage().addItem(new Engine());
			countEngine++;
		}
		while (countBody < kSuppliersBody) {
			Factory.items.getBodyStorage().addItem(new Body());
		}
		while (countAccessory < kSuppliersAccessory) {
			Factory.items.getAccessoryStorage().addItem(new Accessory());
		}
		countAccessory++;
		Thread.sleep(speed);
		return Factory.items;
	}
}
