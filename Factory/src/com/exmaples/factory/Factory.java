package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Factory {
	public Factory() {
		storages.put(ACCESSORY, new Storage(Integer.parseInt(config.get(Property.STORAGE_ACCESSORY_SIZE)), ACCESSORY));
		storages.put(ENGINE, new Storage(Integer.parseInt(config.get(Property.STORAGE_ENGINE_SIZE)), ENGINE));
		storages.put(BODY, new Storage(Integer.parseInt(config.get(Property.STORAGE_BODY_SIZE)), BODY));
		getListSupplierEngine();
		getListSupplierBody();
		getListSupplierAccessory();
		getListWorker();
		getListDealer();
	}

	public Item getItemStorage(String name) {
	      
		if(storages.get(name).getSize()==0){
	     wait;
		} 
		item=storages.get(name).getItem();
		return item;
	}

	public Item createItem(Supplier engine) {
		return new Engine(engine);

	}

	public Item createBody(Supplier body) {

		return new Body(body);

	}

	public Item createAccessory(Supplier accessory) {
		return new Accessory(accessory);

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

	public List<Supplier> getListSupplierEngine() {
		return listSupplierEngine;
	}

	public List<Supplier> getListSupplierBody() {
		return listSupplierBody;
	}

	public List<Supplier> getListSupplierAccessory() {
		return listSupplierAccessory;
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
