package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Factory {
	public Factory() {
		loadSuppliersAccessory();
		loadSuppliersBody();
		loadSuppliersEngine();
		getStorage();
		loadWorkers();
		loadDealers();

		getItemSuppliersEngine();
		getItemSuppliersBody();
		getItemSuppliersAccessory();
		// for (Supplier supplier : getListSupplierEngine()) {
		// System.out.println(supplier.getId());
		// }
		getEngineToStorage();
		//
		// getBodyToStorage();
		// getAccessoryToStorage();
		// getItemWorkers();
		// createCar();
		// System.out.println(getStorage().get(AUTO).getStorage().values().toArray());
		// getCarToStorage();
		// orderDealer();
		// sail();
		// getReportDealer();
	}

	public void report() {

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
			transferItem(getStorage().get(AUTO).getStorage(), dealer.getStorage().getStorage(), AUTO);
		}
	}

	public void getCarToStorage() {
		for (Auto car : listCar) {
			transferItem(car.getStorage().getStorage(), getStorage().get(AUTO).getStorage(), AUTO);
		}
	}

	public void getEngineToStorage() {

		for (Supplier supplier : getListSupplierEngine()) {
			System.out.println(supplier.getStorage().values());

			transferItem(supplier.getStorage(), getStorage().get(ENGINE).getStorage(), ENGINE);
			System.out.println(getStorage().get(ENGINE).getStorage().values());
		}
	}

	public void getBodyToStorage() {
		for (Supplier supplier : getListSupplierBody()) {
			System.out.println(supplier.getStorage().values());
			transferItem(supplier.getStorage(), getStorage().get(BODY).getStorage(), BODY);
			System.out.println(getStorage().get(BODY).getStorage().values());
		}
	}

	public void getAccessoryToStorage() {
		for (Supplier supplier : getListSupplierAccessory()) {
			System.out.println(supplier.getStorage().values());
			transferItem(supplier.getStorage(), getStorage().get(ACCESSORY).getStorage(), ACCESSORY);
		}

	}

	public void getItemWorkers() {
		for (Worker worker : listWorker) {
			transferItem(getStorage().get(ENGINE).getStorage(), worker.getStorage(), ENGINE);
			transferItem(getStorage().get(BODY).getStorage(), worker.getStorage(), BODY);
			transferItem(getStorage().get(ACCESSORY).getStorage(), worker.getStorage(), ACCESSORY);
		}
	}

	public static void AddItem(Storage to, Item item) {
		to.addItem(item);
	}

	public void transferItem(ConcurrentHashMap<Integer, Item> from, ConcurrentHashMap<Integer, Item> to, String name) {
		Item item = new Item();
		for (int key : from.keySet()) {
			if (from.get(key).getName().equals(name)) {
				item = from.get(key);
				to.putIfAbsent(key, from.get(key));
			}
		}
		System.out.println(item);
	}

	public void createCar() {
		for (Worker worker : listWorker) {
			listCar.add(new Auto((Engine) worker.getItem(ENGINE), (Body) worker.getItem(BODY),
					(Accessory) worker.getItem(ACCESSORY)));
		}
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
			// System.out.println(getListSupplier(ENGINE).iterator().next().getId());
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

	public int getReportDealer() {
		int k = 0;
		for (Dealer dealer : listDealer) {
			k += dealer.getResultSails();
		}
		System.out.println(k);
		return k;
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

	public List<Supplier> getListSupplierEngine() {
		return listSupplierEngine;
	}

	public List<Supplier> getListSupplierBody() {
		return listSupplierBody;
	}

	public List<Supplier> getListSupplierAccessory() {

		return listSupplierAccessory;
	}

	public ConcurrentHashMap<Item, String> getItems() {
		return items;
	}

	private void getItemSuppliersEngine() {
		for (Supplier supplierEngine : getListSupplierEngine()) {
			supplierEngine.addItem(createEngine());
		}
	}

	private void getItemSuppliersBody() {
		for (Supplier supplierBody : getListSupplierBody()) {
			supplierBody.addItem(createBody());
		}
	}

	private void getItemSuppliersAccessory() {
		for (Supplier supplierAccessory : getListSupplierAccessory()) {
			supplierAccessory.addItem(createAccessory());
		}
	}

	private Item createEngine() {
		ExecutorService threadEngine = Executors.newSingleThreadExecutor();
		Future<Item> resultEngine = threadEngine.submit(new ItemCreator(ENGINE));
		try {
			engine = (Engine) resultEngine.get();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}
		return engine;
	}

	private Item createBody() {
		ExecutorService threadBody = Executors.newSingleThreadExecutor();
		Future<Item> resultBody = threadBody.submit(new ItemCreator(BODY));
		try {
			body = (Body) resultBody.get();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}
		return body;
	}

	private Item createAccessory() {
		ExecutorService threadAccessory = Executors.newSingleThreadExecutor();
		Future<Item> resultAccessory = threadAccessory.submit(new ItemCreator(Factory.ACCESSORY));
		try {
			accessory = (Accessory) resultAccessory.get();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}
		return accessory;
	}

	List<Integer> size = new ArrayList<>();
	List<Auto> listCar = new ArrayList<Auto>();
	List<Supplier> listSuppliers = new ArrayList<Supplier>();
	List<Supplier> listSupplierEngine = new ArrayList<Supplier>();
	List<Supplier> listSupplierBody = new ArrayList<Supplier>();
	List<Supplier> listSupplierAccessory = new ArrayList<Supplier>();
	List<Dealer> listDealer = new ArrayList<Dealer>();
	List<Worker> listWorker = new ArrayList<Worker>();
	public ConcurrentHashMap<Item, String> items = new ConcurrentHashMap<>();
	private Engine engine;
	private Body body;
	private Accessory accessory;
	public static final String BODY = "Body";
	public static final String ENGINE = "Engine";
	public static final String ACCESSORY = "Accessory";
	public static final String AUTO = "Auto";
	public static final String DEALER = "Dealer";
	public static final String WORKER = "Worker";
	public static ConcurrentHashMap<String, Storage> storages = new ConcurrentHashMap<>();
	private final int kSuppliersEngine = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
	private final int kSuppliersBody = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
	private final int kSuppliersAccessory = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
}
