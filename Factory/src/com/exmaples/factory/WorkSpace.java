package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WorkSpace {
	private static Logger log = Logger.getLogger(WorkSpace.class.getName());
	private Engine engine;
	private Body body;
	private Accessory accessory;
	private int menedgers = Integer.parseInt(Property.getConfig().get((Property.MENEDGERS)));
	private Performer<Engine> SupplierEngine;
	private Performer<Body> SupplierBody;
	private Performer<Accessory> SupplierAccessory;
	private BodyCreator createBody = new BodyCreator(Property.BODY);
	private EngineCreator createEngine = new EngineCreator(Property.ENGINE);
	private AccessoryCreator createaccessory = new AccessoryCreator(Property.ACCESSORY);
	public Factory factory = new Factory();

	List<Menedger> listMenedger = new ArrayList<>();

	public WorkSpace() {

		loadMenedgers();
		loadSuppliersEngine();
		loadSuppliersBody();
		loadSuppliersAccessory();
		begin();
		results();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		SupplierAccessory.setOrder(order);
		SupplierBody.setOrder(order);
		SupplierEngine.setOrder(order);
	}

	public void begin() {
		setOrder(getOrder());
		
		for ( : listSuppliers) {
			TransferforSupplierRunnable items = new TransferforSupplierRunnable(Item.ENGINE, supplier,
					factory.storages.get(Item.ENGINE));
			Thread begin = new Thread(items);
			begin.start();
		}

		for (Worker worker : factory.listWorker) {
			TransferForWorkers work = new TransferForWorkers(worker, factory.storages.get(Item.ENGINE),
					factory.storages.get(Item.BODY), factory.storages.get(Item.ACCESSORY),
					factory.storages.get(Auto.AUTO));
			Thread middle = new Thread(work);
			middle.start();
		}

		for (Menedger menedger : listMenedger) {
			Sails sail = new Sails(factory.storages.get(Auto.AUTO), menedger);
			Thread end = new Thread(sail);
			end.start();
		}
	}

	public void results() {
		for (Menedger menedger : listMenedger) {
			System.out.println("order:" + menedger.getOrderCar());
			System.out.println("get:" + menedger.getResultSails());
		}
	}

	public void loadMenedgers() {
		for (int i = 0; i < menedgers; i++) {
			Menedger menedger = new Menedger();
			menedger.setOrderCar();
			listMenedger.add(menedger);
		}

	}

	public void loadSuppliersBody() {
		SupplierBody = new Performer<Body>();
	}

	public void loadSuppliersAccessory() {

		SupplierAccessory = new Performer<Accessory>();

	}

	public void loadSuppliersEngine() {
		SupplierEngine = new Performer<Engine>();
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
