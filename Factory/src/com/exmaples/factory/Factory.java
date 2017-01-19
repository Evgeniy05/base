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
		getListSupplierEngine();
		getListSupplierBody();
		getListSupplierAccessory();
		getListWorker();
		getListDealer();
	}

	// public void setId(Object obj){
	// if(obj.getClass().getSimpleName()=="Accessory"){
	//
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	// if(obj.getClass().getSimpleName()=="Accessory"){
	// id=;
	// }
	//
	// }
	public Item createItem(){
		
			int idItem=1;
			long date=1;
			item=new Accessory(idItem,.,getName(),date);
		}return item;

	}

	public List<Supplier> loadSuppliersEngine() {
		int k = Integer.parseInt(config.get(Property.ENGINE_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplierEngine.add(new Supplier(id, ENGINE));
		}
		return listSupplierEngine;
	}

	public List<Supplier> loadSuppliersBody() {
		int k = Integer.parseInt(config.get(Property.BODY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplierBody.add(new Supplier(id, BODY));
		}
		return listSupplierBody;
	}

	public List<Supplier> loadSuppliersAccessory() {
		int k = Integer.parseInt(config.get(Property.ACCESSORY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listSupplierAccessory.add(new Supplier(id, ACCESSORY));
		}
		return listSupplierAccessory;
	}

	public List<Dealer> loadDealers() {
		int k = Integer.parseInt(config.get(Property.DEALERS));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listDealer.add(new Dealer(id, DEALER));
		}
		return listDealer;
	}

	public List<Worker> loadWorkers() {
		int k = Integer.parseInt(config.get(Property.WORKERS));
		for (int i = 0; i < k; i++) {
			int id = 1 * k;
			listWorker.add(new Worker(id));
		}
		return listWorker;
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
	private Map<String, Warehouse> storages;
	private Map<String, String> config = Property.getConfig();
	public static final String ACCESSORY = "accessory";
	public static final String ENGINE = "engine";
	public static final String BODY = "body";
	public static final String AUTO = "auto";
	public static final String DEALER = "Dealer";
	private Item item;
}
