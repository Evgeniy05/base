package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Factory {
	public Factory() {
		getStorage();
		loadWorkers();

	}

	public synchronized void createCar() throws InterruptedException {
		for (Worker worker : listWorker) {
			worker.setEngine((Engine) storages.get(Item.ENGINE).getItem(Item.ENGINE));
			worker.setBody((Body) storages.get(Item.BODY).getItem(Item.BODY));
			worker.setAccessory((Accessory) storages.get(Item.ACCESSORY).getItem(Item.ACCESSORY));
			storages.get(AUTO).addItem(new Auto(worker.getEngine(), worker.getBody(), worker.getAccessory()));
		}
	}

	public void loadStorages() {
		storages.put(Item.ACCESSORY, new Storage(
				Integer.parseInt(Property.getConfig().get(Property.STORAGE_ACCESSORY_SIZE)), Item.ACCESSORY));
		storages.put(Item.ENGINE,
				new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_ENGINE_SIZE)), Item.ENGINE));
		storages.put(Item.BODY,
				new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_BODY_SIZE)), Item.BODY));
		storages.put(Auto.AUTO,
				new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_AUTO_SIZE)), Auto.AUTO));

	}

	public Map<String, Storage> getStorage() {
		if (storages == null || storages.isEmpty()) {
			loadStorages();
		}
		return storages;
	}

	public void loadWorkers() {
		int k = Integer.parseInt(Property.getConfig().get((Property.WORKERS)));
		for (int i = 0; i < k; i++) {
			listWorker.add(new Worker());
		}

	}

	List<Worker> listWorker = new ArrayList<Worker>();
	public ConcurrentHashMap<Item, String> items = new ConcurrentHashMap<>();
	public static final String AUTO = "Auto";
	public static final String WORKER = "Worker";
	public ConcurrentHashMap<String, Storage> storages = new ConcurrentHashMap<>();

}
