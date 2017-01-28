package com.exmaples.factory;

public class Items {
	public Items() {
		engineStorage = new Storage();
		bodyStorage = new Storage();
		accessoryStorage = new Storage();
	}

	public Storage getEngineStorage() {
		return engineStorage;
	}

	public Storage getBodyStorage() {
		return bodyStorage;
	}

	public Storage getAccessoryStorage() {
		return accessoryStorage;
	}

	private Storage engineStorage, bodyStorage, accessoryStorage;
}
