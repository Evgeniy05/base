package com.exmaples.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
	public Factory() {
		loadSuppliersAccessory();
		loadSuppliersBody();
		loadSuppliersEngine();
		getStorage();
		loadWorkers();
		loadDealers();
		supplierEngine = getSupplier(ENGINE);
		supplierBody = getSupplier(BODY);
		supplierAccessory = getSupplier(ACCESSORY);
		Engine engineCar = createEngine(supplierEngine, ENGINE);
		AddItem(supplierEngine.getStorage(), engineCar);
		Body bodyCar = createBody(supplierBody, BODY);
		AddItem(supplierBody.getStorage(), bodyCar);
		Accessory accessoryCar = createAccessory(supplierAccessory, ACCESSORY);
		AddItem(supplierAccessory.getStorage(), accessoryCar);
		worker = getWorker();
		dealer = getDealer();

		transferItem(supplierEngine.getStorage(), worker.getStorage(), engineCar);
		transferItem(supplierBody.getStorage(), worker.getStorage(), bodyCar);
		transferItem(supplierAccessory.getStorage(), worker.getStorage(), accessoryCar);
		car = createCar(worker);
		// transferItem(worker.getStorage(), car.getStorage(),
		// worker.getEngine());
		// transferItem(worker.getStorage(), car.getStorage(),
		// worker.getBody());
		// transferItem(worker.getStorage(), car.getStorage(),
		// worker.getAccessory());
		// transferItem(car.getStorage(), getStorage().get(AUTO), car);
		// transferItem(getStorage().get(AUTO), dealer.getStorage(),
		// getStorage().get(AUTO).getItemRemove());
	}

	public void sail(Dealer dealer) {

	}

	public static void AddItem(Storage to, Item item) {
		to.addItem(item);
	}

	public static void transferItem(Storage from, Storage to, Item item) {
		from.itemRemove(item);
		to.addItem(item);
	}

	public Auto createCar(Worker worker) {
		engine = (Engine) worker.getStorage().getItem(ENGINE);
		body = (Body) worker.getStorage().getItem(BODY);
		accessory = (Accessory) worker.getStorage().getItem(ACCESSORY);
		Auto car = new Auto(engine, body, accessory);
		// System.out.println(engine.getDate());
		// System.out.println(body.getDate());
		// System.out.println(accessory.getDate());
		return car;
	}

	public Engine createEngine(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			engine = new Engine(supplier);
		}
		return engine;
	}

	public Body createBody(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			body = new Body(supplier);
		}
		return body;
	}

	public Accessory createAccessory(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			accessory = new Accessory(supplier);
		}
		return accessory;
	}

	public static Map<String, Storage> loadStorages() {
		Map<String, Storage> load = new HashMap<>();
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

	public Supplier getSupplier(String name) {
		switch (name) {
		case ENGINE:
			if (getListSupplier(ENGINE).iterator().hasNext() == true)
				supplier = getListSupplier(ENGINE).iterator().next();
			break;
		case BODY:
			if (getListSupplier(BODY).iterator().hasNext() == true)
				supplier = getListSupplier(BODY).iterator().next();
			break;
		case ACCESSORY:
			if (getListSupplier(ACCESSORY).iterator().hasNext() == true)
				supplier = getListSupplier(ACCESSORY).iterator().next();
			break;
		}
		return supplier;
	}

	public List<Dealer> getListDealer() {
		return listDealer;
	}

	public Dealer getDealer() {
		if (getListDealer().iterator().hasNext() == true)
			return getListDealer().iterator().next();
		return null;
	}

	public List<Worker> getListWorker() {
		return listWorker;
	}

	public Worker getWorker() {
		if (getListWorker().iterator().hasNext() == true)
			return getListWorker().iterator().next();
		return null;
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

	List<Item> listItem = new ArrayList<Item>();
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
	private static Map<String, Storage> storages = new HashMap<>();
	public Item item;
	Engine engine;
	Body body;
	Accessory accessory;
	public Auto car;
	public Worker worker;
	public Dealer dealer;
	public Supplier supplier, supplierEngine, supplierBody, supplierAccessory;

}
