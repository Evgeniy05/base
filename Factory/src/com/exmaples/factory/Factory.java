package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Factory {
	public Factory() {
		storages.put(ACCESSORY,
				new Warehouse(Integer.parseInt(config.get(Property.STORAGE_ACCESSORY_SIZE)), ACCESSORY));
		storages.put(ENGINE, new Warehouse(Integer.parseInt(config.get(Property.STORAGE_ENGINE_SIZE)), ENGINE));
		storages.put(BODY, new Warehouse(Integer.parseInt(config.get(Property.STORAGE_BODY_SIZE)), BODY));
		storages.put(AUTO, new Warehouse(Integer.parseInt(config.get(Property.STORAGE_AUTO_SIZE)), AUTO));

	}

public void setId(Object obj){
	if(obj.getClass().getSimpleName()=="Accessory"){
		
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	if(obj.getClass().getSimpleName()=="Accessory"){
		id=;
	}
	
}

	public List<Supplier> getSuppliersEngine() {
		int k = Integer.parseInt(config.get(ENGINE));
		if (listSupplier.isEmpty()) {
			loadSuppliersEngine(k);
		}
		return listSupplier;
	}

	public List<Supplier> loadSuppliersEngine(int k) {
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplier.add(new Supplier(id, ENGINE));
		}
		return listSupplier;
	}

	public List<Supplier> suppliersBody() {
		int k = Integer.parseInt(config.get(BODY));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplier.add(new Supplier(id, BODY));
		}
		return listSupplier;
	}

	public List<Supplier> suppliersAccessory() {
		int k = Integer.parseInt(config.get(ACCESSORY));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplier.add(new Supplier(id, ACCESSORY));
		}
		return listSupplier;
	}

	public Warehouse getWarehouseById(String id) {
		return storages.get(id);
	}

	public Warehouse getWarehouseAccessory() {
		return storages.get(ACCESSORY);
	}

	public Warehouse getWarehouseEgine() {
		return storages.get(ENGINE);
	}

	public Warehouse getWarehouseBody() {
		return storages.get(BODY);
	}

	public Warehouse getWarehouseAuto() {
		return storages.get(AUTO);
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

	List<Item> listItem = new ArrayList<Item>();
	List<Supplier> listSupplier = new ArrayList<Supplier>();
	List<Dealer> listDealer = new ArrayList<Dealer>();
	List<Worker> listWorker = new ArrayList<Worker>();
	// Warehouse warehouseEngine;
	// Warehouse warehouseBody;
	// Warehouse warehouseAccessory;
	// Warehouse warehouseAuto;
	private Map<String, Warehouse> storages;
	private Map<String, String> config = Property.getConfig();
	public final String ACCESSORY = "accessory";
	public final String ENGINE = "engine";
	public final String BODY = "body";
	public final String AUTO = "auto";

}
