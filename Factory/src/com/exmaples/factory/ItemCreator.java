package com.exmaples.factory;

import java.util.concurrent.Callable;

public class ItemCreator implements Callable<Supplier> {
	// private int count = 0;
	private Supplier supplier;
	private static final String BODY = "Body";
	private static final String ENGINE = "Engine";
	private static final String ACCESSORY = "Accessory";

	public ItemCreator(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public Supplier call() throws InterruptedException {

		return create(supplier.getSpeed());
	}

	public Supplier create(long speed) throws InterruptedException {
		if (supplier.isFlag()) {
			switch (supplier.getName()) {
			case ENGINE:
				supplier.getStorage().addItem(new Engine());
				Thread.sleep(speed);
				break;
			case BODY:
				supplier.getStorage().addItem(new Body());
				Thread.sleep(speed);
				break;
			case ACCESSORY:
				supplier.getStorage().addItem(new Accessory());
				Thread.sleep(speed);
				break;
			}

		}

		return supplier;

	}
}
