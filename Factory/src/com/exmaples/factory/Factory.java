package com.exmaples.factory;

import java.util.concurrent.ConcurrentHashMap;

public class Factory {

	public HeadWorker headWorker = new HeadWorker();
	public ConcurrentHashMap<Item, String> items = new ConcurrentHashMap<>();
	public Storage<Accessory> accessory;
	public Storage<Body> body;
	public Storage<Engine> engine;
	public Storage<Auto> auto;
	public static final String AUTO = "Auto";
	public static final String WORKER = "Worker";

	public Factory() {
		loadStorages();
	}

	public void loadStorages() {
		accessory = new Storage<Accessory>(Integer.parseInt(Property.getConfig().get(Property.STORAGE_ACCESSORY_SIZE)),
				Property.ACCESSORY);
		engine = new Storage<Engine>(Integer.parseInt(Property.getConfig().get(Property.STORAGE_ENGINE_SIZE)),
				Property.ENGINE);
		body = new Storage<Body>(Integer.parseInt(Property.getConfig().get(Property.STORAGE_BODY_SIZE)), Property.BODY);
		auto = new Storage<Auto>(Integer.parseInt(Property.getConfig().get(Property.STORAGE_AUTO_SIZE)), Auto.AUTO);

	}

	public Storage<Accessory> getStorageAccessory() {
		return accessory;
	}

	public Storage<Body> getStorageBody() {
		return body;
	}

	public Storage<Engine> getStorageEngine() {
		return engine;
	}

	public Storage<Auto> getStorageAuto() {
		return auto;
	}

}
