package com.exmaples.factory;

import java.util.concurrent.Callable;

public class ItemCreator implements Callable<Supplier> {
	private Supplier supplier;
	private static final String BODY = "Body";
	private static final String ENGINE = "Engine";
	private static final String ACCESSORY = "Accessory";
	private Engine engine;
	private Body body;
	private Accessory accessory;

	public ItemCreator(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public Supplier call() throws InterruptedException {

		return create(supplier.getSpeed());
	}

	public Supplier create(long speed) throws InterruptedException {
		if (supplier.isFlag() == false) {
		} else {
			switch (supplier.getName()) {
			case ENGINE:
				engine = new Engine();
				supplier.getStorage().addItem(engine);
				Thread.sleep(speed);
				break;
			case BODY:
				body = new Body();
				supplier.getStorage().addItem(body);
				Thread.sleep(speed);
				break;
			case ACCESSORY:
				accessory = new Accessory();
				supplier.getStorage().addItem(accessory);
				Thread.sleep(speed);
				break;
			}

		}

		return supplier;

	}
}
