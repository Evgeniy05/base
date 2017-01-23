package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Factory {
	public Factory() {
		storages.put(ACCESSORY, new Storage(Integer.parseInt(config.get(Property.STORAGE_ACCESSORY_SIZE)), ACCESSORY));
		storages.put(ENGINE, new Storage(Integer.parseInt(config.get(Property.STORAGE_ENGINE_SIZE)), ENGINE));
		storages.put(BODY, new Storage(Integer.parseInt(config.get(Property.STORAGE_BODY_SIZE)), BODY));
		getListSupplier(ENGINE);
		getListSupplier(BODY);
		getListSupplier(ACCESSORY);
		getListWorker();
		getListDealer();
	}

	public Map<String, Storage> getStorages() {
		return storages;
	}

	public synchronized void createItemEngine(Supplier supplier) throws InterruptedException {

		while (storages.get(ENGINE).getFreeValue() == 0)
			wait();
		storages.get(ENGINE).addItem(new Engine(supplier));
		notifyAll();
	}

	public synchronized void createItemBody(Supplier supplier) throws InterruptedException {

		while (storages.get(BODY).getFreeValue() == 0)
			wait();
		storages.get(BODY).addItem(new Engine(supplier));
		notifyAll();
	}

	public synchronized void createItemAccessory(Supplier supplier) throws InterruptedException {

		while (storages.get(ACCESSORY).getFreeValue() == 0)
			wait();
		storages.get(ACCESSORY).addItem(new Engine(supplier));
		notifyAll();
	}

	public synchronized void getEngineStorage(Item engine, Worker worker) throws InterruptedException {

		while (storages.get(ENGINE).getFreeValue() == 0)
			wait();
		worker.addItem(storages.get(ENGINE).getItem(item));

	}

	public synchronized void getBodyStorage(Item body, Worker worker) throws InterruptedException {

		while (storages.get(BODY).getFreeValue() == 0)
			wait();
		worker.addItem(storages.get(BODY).getItem(item));

	}

	public synchronized void getAccessoryStorage(Item accessory, Worker worker) throws InterruptedException {

		while (storages.get(ACCESSORY).getFreeValue() == 0)
			wait();
		worker.addItem(storages.get(ACCESSORY).getItem(item));

	}

	public List<Supplier> loadSuppliersEngine() {
		int k = Integer.parseInt(config.get(Property.ENGINE_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			listSupplierEngine.add(new Supplier(ENGINE));
		}
		return listSupplierEngine;
	}

	public List<Supplier> loadSuppliersBody() {
		int k = Integer.parseInt(config.get(Property.BODY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			listSupplierBody.add(new Supplier(BODY));
		}
		return listSupplierBody;
	}

	public List<Supplier> loadSuppliersAccessory() {
		int k = Integer.parseInt(config.get(Property.ACCESSORY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			listSupplierAccessory.add(new Supplier(ACCESSORY));
		}
		return listSupplierAccessory;
	}

	public List<Dealer> loadDealers() {
		int k = Integer.parseInt(config.get(Property.DEALERS));
		for (int i = 0; i < k; i++) {
			listDealer.add(new Dealer(DEALER));
		}
		return listDealer;
	}

	public List<Worker> loadWorkers() {
		int k = Integer.parseInt(config.get(Property.WORKERS));
		for (int i = 0; i < k; i++) {
			listWorker.add(new Worker(WORKER));
		}
		return listWorker;
	}

	public Storage getStorageById(String id) {
		return storages.get(id);
	}

	public List<Supplier> getListSupplier(String name) {
		if (name == ENGINE)
			listSuppliers = listSupplierEngine;
		if (name == BODY) {
			listSuppliers = listSupplierBody;
		}
		if (name == ACCESSORY) {
			listSuppliers = listSupplierAccessory;
		}
		return listSuppliers;
	}

	public List<Dealer> getListDealer() {
		if (listDealer.isEmpty()) {
			listDealer = loadDealers();
		}
		return listDealer;
	}

	public List<Worker> getListWorker() {
		if (listWorker.isEmpty()) {
			listWorker = loadWorkers();
		}
		return listWorker;
	}

	List<Item> listItem = new ArrayList<Item>();
	List<Supplier> listSuppliers = new ArrayList<Supplier>();
	List<Supplier> listSupplierEngine = new ArrayList<Supplier>();
	List<Supplier> listSupplierBody = new ArrayList<Supplier>();
	List<Supplier> listSupplierAccessory = new ArrayList<Supplier>();
	List<Dealer> listDealer = new ArrayList<Dealer>();
	List<Worker> listWorker = new ArrayList<Worker>();
	private Map<String, Storage> storages;
	private Map<String, String> config = Property.getConfig();
	public static final String ACCESSORY = "accessory";
	public static final String ENGINE = "engine";
	public static final String BODY = "body";
	public static final String AUTO = "auto";
	public static final String DEALER = "Dealer";
	public static final String WORKER = "Worker";
	private final String SUPPLIER = "Supplier";
	private Item item;;

}
