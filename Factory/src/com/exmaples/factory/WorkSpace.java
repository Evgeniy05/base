package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkSpace {
	private static Logger log = Logger.getLogger(WorkSpace.class.getName());
	private Engine engine;
	private Body body;
	private Accessory accessory;
	public Factory factory = new Factory();
	List<Supplier> listSuppliers = new ArrayList<Supplier>();
	List<Supplier> listSupplierEngine = new ArrayList<Supplier>();
	List<Supplier> listSupplierBody = new ArrayList<Supplier>();
	List<Supplier> listSupplierAccessory = new ArrayList<Supplier>();
	List<Menedger> listMenedger = new ArrayList<>();
	{
		loadMenedgers();
		loadSuppliersEngine();
		loadSuppliersBody();
		loadSuppliersAccessory();
		getEngineToSupplier();
		getBodyToSupplier();
		getAccessoryToSupplier();
		try {
			getEngineToStorage();
			log.info("engine step2");
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		}
		try {
			getBodyToStorage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			getAccessoryToStorage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			factory.createCar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Sails();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		results();

	}

	public WorkSpace() {

	}

	public void results() {
		for (Menedger menedger : listMenedger) {
			System.out.println("order:" + menedger.getOrderCar());
			System.out.println("get:" + menedger.getResultSails());
		}
	}

	public synchronized void Sails() throws InterruptedException {
		for (Menedger menedger : listMenedger) {
			while (menedger.getOrderCar() != menedger.getResultSails()) {
				menedger.Sail((Auto) factory.storages.get(Auto.AUTO).getItem(Auto.AUTO));
			}
		}
	}

	public void loadMenedgers() {
		int k = Integer.parseInt(Property.getConfig().get((Property.MENEDGERS)));
		for (int i = 0; i < k; i++) {
			Menedger menedger = new Menedger();
			menedger.setOrderCar();
			listMenedger.add(menedger);
		}

	}

	public void getEngineToSupplier() {
		for (Supplier supplier : listSupplierEngine) {
			createEngine(supplier);

		}
	}

	public void getBodyToSupplier() {
		for (Supplier supplier : listSupplierBody) {
			createBody(supplier);

		}
	}

	public void getAccessoryToSupplier() {
		for (Supplier supplier : listSupplierAccessory) {
			createAccessory(supplier);

		}
	}

	public void getEngineToStorage() throws InterruptedException {
		for (Supplier supplier : listSupplierEngine) {
			factory.storages.get(Item.ENGINE).addItem(supplier.getItem());
		}
	}

	public void getBodyToStorage() throws InterruptedException {
		for (Supplier supplier : listSupplierBody) {
			factory.storages.get(Item.BODY).addItem(supplier.getItem());
		}
	}

	public void getAccessoryToStorage() throws InterruptedException {
		for (Supplier supplier : listSupplierAccessory) {
			factory.storages.get(Item.ACCESSORY).addItem(supplier.getItem());
		}
	}

	public void loadSuppliersEngine() {
		int k = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
		for (int i = 0; i < k; i++) {
			listSupplierEngine.add(new Supplier(Item.ENGINE));
			// System.out.println(getListSupplier(ENGINE).iterator().next().getId());
		}
	}

	public void loadSuppliersBody() {
		int k = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
		for (int i = 0; i < k; i++) {
			listSupplierBody.add(new Supplier(Item.BODY));
		}

	}

	public void loadSuppliersAccessory() {
		int k = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
		for (int i = 0; i < k; i++) {
			listSupplierAccessory.add(new Supplier(Item.ACCESSORY));
		}

	}

	private Item createEngine(Supplier supplier) {
		ExecutorService threadEngine = Executors.newSingleThreadExecutor();
		Future<Item> resultEngine = threadEngine.submit(new ItemCreator(Item.ENGINE));
		try {
			engine = (Engine) resultEngine.get();
			supplier.setItem(engine);
			log.info("engine");
		} catch (InterruptedException e) {

			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		} catch (ExecutionException e) {

			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		}
		return engine;
	}

	private Item createBody(Supplier supplier) {
		ExecutorService threadBody = Executors.newSingleThreadExecutor();
		Future<Item> resultBody = threadBody.submit(new ItemCreator(Item.BODY));
		try {
			body = (Body) resultBody.get();
			supplier.setItem(body);
			log.info("create body");
		} catch (InterruptedException e) {

			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		} catch (ExecutionException e) {

			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		}
		return body;
	}

	private Item createAccessory(Supplier supplier) {
		ExecutorService threadAccessory = Executors.newSingleThreadExecutor();
		Future<Item> resultAccessory = threadAccessory.submit(new ItemCreator(Item.ACCESSORY));
		try {
			accessory = (Accessory) resultAccessory.get();
			supplier.setItem(accessory);
			log.info("create accessory");
		} catch (InterruptedException e) {

			e.printStackTrace();
			log.log(Level.SEVERE, e.toString(), e);
		} catch (ExecutionException e) {
			log.log(Level.SEVERE, e.toString(), e);
			e.printStackTrace();

		}
		return accessory;
	}

}
