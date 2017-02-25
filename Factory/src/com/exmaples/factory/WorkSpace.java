package com.exmaples.factory;

import java.util.logging.Logger;

public class WorkSpace {
	private static Logger log = Logger.getLogger(WorkSpace.class.getName());
	private Performer<Engine> SupplierEngine = new Performer<Engine>();
	private Performer<Body> SupplierBody = new Performer<Body>();
	private Performer<Accessory> SupplierAccessory = new Performer<Accessory>();
	private BodyCreator createBody = new BodyCreator(Property.BODY);
	private EngineCreator createEngine = new EngineCreator(Property.ENGINE);
	private AccessoryCreator createaccessory = new AccessoryCreator(Property.ACCESSORY);
	public Factory factory = new Factory();
	private HeadMenedger menedgers = new HeadMenedger();

	public WorkSpace() {

		SupplierAccessory.loadSuppliers(createaccessory);
		SupplierBody.loadSuppliers(createBody);
		SupplierEngine.loadSuppliers(createEngine);
		factory.getHeadWorker();
		menedgers.getListMenedger();
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

	public HeadMenedger getMenedgers() {
		return menedgers;
	}

}
