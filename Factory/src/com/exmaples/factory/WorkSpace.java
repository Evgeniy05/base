package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class WorkSpace {
	private static Logger log = Logger.getLogger(WorkSpace.class.getName());
	private int menedgers = Integer.parseInt(Property.getConfig().get((Property.MENEDGERS)));
	private Performer<Engine> SupplierEngine = new Performer<Engine>();
	private Performer<Body> SupplierBody = new Performer<Body>();
	private Performer<Accessory> SupplierAccessory = new Performer<Accessory>();
	private BodyCreator createBody = new BodyCreator(Property.BODY);
	private EngineCreator createEngine = new EngineCreator(Property.ENGINE);
	private AccessoryCreator createaccessory = new AccessoryCreator(Property.ACCESSORY);
	public Factory factory = new Factory();
	private List<Place> listPlaces = new ArrayList<>();
	private ExecutorService pool = Executors.newCachedThreadPool();
	List<Menedger> listMenedger = new ArrayList<>();

	public WorkSpace() throws InterruptedException, ExecutionException {

		loadMenedgers();
		begin();
		// results();
	}

	public Order getOrder() {
		return new Order("", 50);
	}

	public void setOrder() {
		SupplierAccessory.setOrder(getOrder());
		SupplierAccessory.loadSuppliers(createaccessory);
		SupplierAccessory.setSuppliers();
		SupplierBody.setOrder(getOrder());
		SupplierBody.loadSuppliers(createBody);
		SupplierBody.setSuppliers();
		SupplierEngine.setOrder(getOrder());
		SupplierEngine.loadSuppliers(createEngine);
		SupplierEngine.setSuppliers();
		factory.headWorker.setOrder(getOrder());
		factory.headWorker.loadWorkers();
		factory.headWorker.setWorkers();
		listPlaces = factory.headWorker.getAssemblyShop();

	}

	public void begin() throws InterruptedException, ExecutionException {
		setOrder();

		for (Supplier<Engine> supplier : SupplierEngine.getMapOne().keySet()) {
			TransferforSupplierRunnable<Engine> itemEngine = new TransferforSupplierRunnable<Engine>(supplier,
					factory.getStorageEngine(), SupplierEngine.getMapOne().get(supplier));
			Future<Storage<Engine>> resultE = pool.submit(itemEngine, factory.getStorageEngine());
			factory.engine = resultE.get();
		}
		System.out.println(factory.engine.getFreeSpace());
		for (Supplier<Body> supplier : SupplierBody.getMapOne().keySet()) {
			TransferforSupplierRunnable<Body> itemBody = new TransferforSupplierRunnable<Body>(supplier,
					factory.getStorageBody(), SupplierBody.getMapOne().get(supplier));
			Future<Storage<Body>> resultB = pool.submit(itemBody, factory.getStorageBody());
			factory.body = resultB.get();
		}
		System.out.println(factory.body.getFreeSpace());
		for (Supplier<Accessory> supplier : SupplierAccessory.getMapOne().keySet()) {
			TransferforSupplierRunnable<Accessory> itemAccessory = new TransferforSupplierRunnable<Accessory>(supplier,
					factory.getStorageAccessory(), SupplierAccessory.getMapOne().get(supplier));
			Future<Storage<Accessory>> resultA = pool.submit(itemAccessory, factory.getStorageAccessory());
			factory.accessory = resultA.get();
		}

		System.out.println(factory.accessory.getFreeSpace());
		// for (Engine engin : factory.getStorageEngine().getItemList()) {
		// System.out.println(engin.getId());
		// }

		for (Place place : factory.headWorker.getTask().keySet()) {
			for (int i = 0; i < factory.headWorker.getTask().get(place); i++) {
				TransferItemsToStorage<Engine> getEngine = new TransferItemsToStorage<Engine>(
						factory.getStorageEngine(), place);
				Future<Place> resultEngine = pool.submit(getEngine, place);
				place = resultEngine.get();
				// System.out.println(place.getItems());

				TransferItemsToStorage<Body> getBody = new TransferItemsToStorage<Body>(factory.getStorageBody(),
						place);
				Future<Place> resultBody = pool.submit(getBody, place);
				place = resultBody.get();
				// System.out.println(place.getItems());
				TransferItemsToStorage<Accessory> getAccessory = new TransferItemsToStorage<Accessory>(
						factory.getStorageAccessory(), place);
				Future<Place> resultAccessory = pool.submit(getAccessory, place);
				place = resultAccessory.get();
				// System.out.println(place.getItems());
				TransferForWorkers auto = new TransferForWorkers(place, factory.getStorageAuto(), 1);
				Future<Storage<Auto>> resultAuto = pool.submit(auto, factory.getStorageAuto());
				factory.auto = resultAuto.get();
			}
		}

		System.out.println(factory.auto.getItemList());

		System.out.println(factory.auto.getItemList().size());

		pool.shutdownNow();
	}

	public void results() {
		for (Menedger menedger : listMenedger) {
			System.out.println("order:" + menedger.getOrderCar());
			System.out.println("get:" + menedger.getResultSails());
		}
		System.out.println(factory.auto.getResults());
	}

	public void loadMenedgers() {
		for (int i = 0; i < menedgers; i++) {
			Menedger menedger = new Menedger();
			menedger.setOrderCar();
			listMenedger.add(menedger);
		}

	}

	public Performer<Engine> getSupplierEngine() {
		return SupplierEngine;
	}

	public Performer<Body> getSupplierBody() {
		return SupplierBody;
	}

	public Performer<Accessory> getSupplierAccessory() {
		return SupplierAccessory;
	}

}
