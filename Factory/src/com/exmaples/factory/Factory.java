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
		worker = getWorker();
		dealer = getDealer();
		supplierEngine = getSupplier(ENGINE);
		supplierBody = getSupplier(BODY);
		supplierAccessory = getSupplier(ACCESSORY);
		createEngine(supplierEngine, ENGINE);
		createBody(supplierBody, BODY);
		createAccessory(supplierAccessory, ACCESSORY);
		transferItem(supplierEngine.getStorage(), getStorage().get(ENGINE),
				supplierEngine.getStorage().getItem(ENGINE));
		transferItem(supplierBody.getStorage(), getStorage().get(BODY), supplierBody.getStorage().getItem(BODY));
		transferItem(supplierAccessory.getStorage(), getStorage().get(ACCESSORY),
				supplierAccessory.getStorage().getItem(ACCESSORY));
		transferItem(getStorage().get(ENGINE), worker.getStorage(), getStorage().get(ENGINE).getItem(ENGINE));
		transferItem(getStorage().get(BODY), worker.getStorage(), getStorage().get(BODY).getItem(BODY));
		transferItem(getStorage().get(ACCESSORY), worker.getStorage(), getStorage().get(ACCESSORY).getItem(ACCESSORY));
		car = createCar(worker);
		car.getStorage().addItem(car);
		transferItem(car.getStorage(), getStorage().get(AUTO), car.getStorage().getItem(AUTO));
		transferItem(getStorage().get(AUTO), dealer.getStorage(), getStorage().get(AUTO).getItem(AUTO));
		dealer.sail();
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
		return car;
	}

	public void createEngine(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			engine = new Engine(supplier);
			AddItem(supplier.getStorage(), engine);
		}

	}

	public void createBody(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			body = new Body(supplier);
			// System.out.println(body.getDate());
			AddItem(supplier.getStorage(), body);
		}

	}

	public void createAccessory(Supplier supplier, String type) {
		if (supplier.getName() == type) {
			accessory = new Accessory(supplier);
			// System.out.println(accessory.getDate());
			AddItem(supplier.getStorage(), accessory);
		}

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
	private Engine engine;
	private Body body;
	private Accessory accessory;
	public Auto car;
	public Worker worker;
	public Dealer dealer;
	public Supplier supplier, supplierEngine, supplierBody, supplierAccessory;

}
