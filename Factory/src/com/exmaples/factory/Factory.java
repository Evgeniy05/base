package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Factory {
	public Factory() {
		loadSuppliersAccessory();
		loadSuppliersBody();
		loadSuppliersEngine();
		getStorage();
		loadWorkers();
		loadDealers();
		createEngine();
		createBody();
		createAccessory();
		// getOrderSize();
		getEngineToStorage();
		getBodyToStorage();
		getAccessoryToStorage();
		getItemWorkers();
		createCar();
		getCarToStorage();
		orderDealer();
		sail();
	}
	//
	// public void getOrderSize() {
	// Iterator<>
	// while(it.hasnext())
	// getStorage().values().size()
	// }

	public void sail() {
		for (Dealer dealer : listDealer) {
			dealer.sail();
		}
	}

	public void orderDealer() {
		for (Dealer dealer : listDealer) {
			transferItem(getStorage().get(AUTO), dealer.getStorage());
		}
	}

	public void getCarToStorage() {
		for (Auto car : listCar) {
			transferItem(car.getStorage(), getStorage().get(AUTO));
		}
	}

	public void getEngineToStorage() {
		for (Supplier supplier : getListSupplier(ENGINE)) {
			transferItem(supplier.getStorage(), getStorage().get(ENGINE));
		}
	}

	public void getBodyToStorage() {
		for (Supplier supplier : getListSupplier(BODY)) {
			transferItem(supplier.getStorage(), getStorage().get(BODY));
		}
	}

	public void getAccessoryToStorage() {
		for (Supplier supplier : getListSupplier(ACCESSORY)) {
			transferItem(supplier.getStorage(), getStorage().get(ACCESSORY));
		}

	}

	public void getItemWorkers() {
		for (Worker worker : listWorker) {
			transferItem(getStorage().get(ENGINE), worker.getStorage());
			transferItem(getStorage().get(BODY), worker.getStorage());
			transferItem(getStorage().get(ACCESSORY), worker.getStorage());
		}
	}

	public static void AddItem(Storage to, Item item) {
		to.addItem(item);
	}

	public static void transferItem(Storage from, Storage to, Item item) {
		from.itemRemove(item);
		to.addItem(item);
	}

	public static void transferItem(Storage from, Storage to) {
		to.addItem(from.getItem());
		from.itemRemove();
	}

	public void createCar() {
		for (Worker worker : listWorker) {
			listCar.add(new Auto((Engine) worker.getStorage().getItem(ENGINE), (Body) worker.getStorage().getItem(BODY),
					(Accessory) worker.getStorage().getItem(ACCESSORY)));
		}
	}

	public void createEngine() {
		for (Supplier supplier : getListSupplier(ENGINE)) {
			AddItem(supplier.getStorage(), new Engine(supplier));
		}

	}

	public void createBody() {
		for (Supplier supplier : getListSupplier(BODY))
			AddItem(supplier.getStorage(), new Body(supplier));
	}

	public void createAccessory() {
		for (Supplier supplier : getListSupplier(ACCESSORY))
			AddItem(supplier.getStorage(), new Accessory(supplier));
	}

	public static ConcurrentHashMap<String, Storage> loadStorages() {
		ConcurrentHashMap<String, Storage> load = new ConcurrentHashMap<>();
		load.put(ACCESSORY,
				new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_ACCESSORY_SIZE)), ACCESSORY));
		load.put(ENGINE, new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_ENGINE_SIZE)), ENGINE));
		load.put(BODY, new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_BODY_SIZE)), BODY));
		load.put(AUTO, new Storage(Integer.parseInt(Property.getConfig().get(Property.STORAGE_AUTO_SIZE)), AUTO));

		return load;
	}

	public static Map<String, Storage> getStorage() {
		if (storages == null || storages.isEmpty()) {
			storages = loadStorages();
		}
		return storages;
	}

	public void loadSuppliersEngine() {
		int k = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
		for (int i = 0; i < k; i++) {
			listSupplierEngine.add(new Supplier(ENGINE));
		}
	}

	public void loadSuppliersBody() {
		int k = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
		for (int i = 0; i < k; i++) {
			listSupplierBody.add(new Supplier(BODY));
		}

	}

	public void loadSuppliersAccessory() {
		int k = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			listSupplierAccessory.add(new Supplier(ACCESSORY));
		}

	}

	public void loadDealers() {
		int k = Integer.parseInt(Property.getConfig().get((Property.DEALERS)));
		for (int i = 0; i < k; i++) {
			listDealer.add(new Dealer());
		}
	}

	public void loadWorkers() {
		int k = Integer.parseInt(Property.getConfig().get((Property.WORKERS)));
		for (int i = 0; i < k; i++) {
			listWorker.add(new Worker());
		}

	}

	public List<Supplier> getListSupplier(String name) {
		switch (name) {
		case ENGINE:
			listSuppliers = listSupplierEngine;

			break;
		case BODY:
			listSuppliers = listSupplierBody;
			break;
		case ACCESSORY:
			listSuppliers = listSupplierAccessory;
			break;
		}
		return listSuppliers;
	}

	public static String getNameAccessory() {
		return ACCESSORY;
	}

	public static String getNameEngine() {
		return ENGINE;
	}

	public static String getNameBody() {
		return BODY;
	}

	public static String getNameAuto() {
		return AUTO;
	}

	public static String getNameDealer() {
		return DEALER;
	}

	public static String getNameWorker() {
		return WORKER;
	}

	List<Integer> size = new ArrayList<>();
	List<Auto> listCar = new ArrayList<Auto>();
	List<Supplier> listSuppliers = new ArrayList<Supplier>();
	List<Supplier> listSupplierEngine = new ArrayList<Supplier>();
	List<Supplier> listSupplierBody = new ArrayList<Supplier>();
	List<Supplier> listSupplierAccessory = new ArrayList<Supplier>();
	List<Dealer> listDealer = new ArrayList<Dealer>();
	List<Worker> listWorker = new ArrayList<Worker>();
	private static final String BODY = "Body";
	private static final String ENGINE = "Engine";
	private static final String ACCESSORY = "Accessory";
	private static final String AUTO = "Auto";
	private static final String DEALER = "Dealer";
	private static final String WORKER = "Worker";
	private static ConcurrentHashMap<String, Storage> storages = new ConcurrentHashMap<>();

}
