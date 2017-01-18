package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Factory {
	public Factory() {
		storages.put(ACCESSORY, new Warehouse(config.get(Property.STORAGE_ACCESSORY_SIZE), ACCESSORY));
	}

	public Warehouse getWarehouseById(String id) {
		return storages.get(id);
	}

	public Warehouse getWarehouseAccessory() {
		return storages.get(ACCESSORY);
	}

	public List<Supplier> getListSupplier() {
		return listSupplier;
	}

	public List<Dealer> getListDealer() {
		return listDealer;
	}

	public List<Worker> getListWorker() {
		return listWorker;
	}

	List<Item> listComponent = new ArrayList<Item>();
	List<Supplier> listSupplier = new ArrayList<Supplier>();
	List<Dealer> listDealer = new ArrayList<Dealer>();
	List<Worker> listWorker = new ArrayList<Worker>();
	// Warehouse warehouseEngine;
	// Warehouse warehouseBody;
	// Warehouse warehouseAccessory;
	// Warehouse warehouseAuto;
	private Map<String, Warehouse> storages;
	private Map<String, Integer> config = Property.getConfig();
	public final String ACCESSORY = "accessory";
	public final String  = "accessory";
	public final String ACCESSORY = "accessory";
	public final String ACCESSORY = "accessory";
}
