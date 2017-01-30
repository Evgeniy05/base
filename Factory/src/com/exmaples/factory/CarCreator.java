package com.exmaples.factory;

import java.util.concurrent.Callable;

public class CarCreator implements Callable<Auto> {

	private String name;
	private int order;
	private Auto car;

	public CarCreator(String name, int order, Storage engineStorage, Storage bodyStorage, Storage accessoryStorage,
			Worker woker) {

	}

	@Override
	public Auto call() throws InterruptedException {

		return create(name);
	}

	public Auto create(String aName) throws InterruptedException {

		// Thread.sleep(speed);
		return car;
	}
}
