package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Factory {
	private int workers = Integer.parseInt(Property.getConfig().get((Property.WORKERS)));
	List<Worker> listWorker = new ArrayList<Worker>();
	public ConcurrentHashMap<Item, String> items = new ConcurrentHashMap<>();
	private Storage<Accessory> accessory;
	private Storage<Body> body;
	private Storage<Engine> engine;
	private Storage<Auto> auto;
	public static final String AUTO = "Auto";
	public static final String WORKER = "Worker";

	public Factory() {
		loadStorages();
		loadWorkers();

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

	public void loadWorkers() {
		for (int i = 0; i < workers; i++) {
			listWorker.add(new Worker());
		}

	}

}
