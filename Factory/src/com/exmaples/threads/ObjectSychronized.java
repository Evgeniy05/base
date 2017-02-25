package com.exmaples.threads;

public class ObjectSychronized {
	// private Auto isEmptyCar = new Auto(new Engine("", 1), new Body("", 1),
	// new Accessory("", 1));
	// private Auto isFullCar = new Auto(new Engine("", 2), new Body("", 2), new
	// Accessory("", 2));
	// private Engine isFullEngine = new Engine("", 3);
	// private Engine isEmptyEngine = new Engine("", 4);
	// private Body isFullBody = new Body("", 3);
	// private Body isEmptyBody = new Body("", 4);
	// private Accessory isFullAccessory = new Accessory("", 3);
	// private Accessory isEmptyAccessory = new Accessory("", 4);
	private Object isEmptyItem = new Object();
	private Object isFullItem = new Object();
	private Object isFullAuto = new Object();
	private Object isEmptyAuto = new Object();

	public ObjectSychronized() {
	}

	public Object getIsEmptyItem() {
		return isEmptyItem;
	}

	public Object getIsFullItem() {
		return isFullItem;
	}

	public Object getIsFullAuto() {
		return isFullAuto;
	}

	public Object getIsEmptyAuto() {
		return isEmptyAuto;
	}

	// public Engine getIsFullEngine() {
	// return isFullEngine;
	// }
	//
	// public Engine getIsEmptyEngine() {
	// return isEmptyEngine;
	// }
	//
	// public Body getIsFullBody() {
	// return isFullBody;
	// }
	//
	// public Body getIsEmptyBody() {
	// return isEmptyBody;
	// }
	//
	// public Accessory getIsFullAccessory() {
	// return isFullAccessory;
	// }
	//
	// public Accessory getIsEmptyAccessory() {
	// return isEmptyAccessory;
	// }
	//
	// public Auto getIsEmptyCar() {
	// return isEmptyCar;
	// }
	//
	// public Auto getIsFullCar() {
	// return isFullCar;
	// }

}
