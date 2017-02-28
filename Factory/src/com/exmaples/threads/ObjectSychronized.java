package com.exmaples.threads;

public class ObjectSychronized {
	// private Auto isEmptyCar = new Auto(new Engine("", 1), new Body("", 1),
	// new Accessory("", 1));
	// private Auto isFullCar = new Auto(new Engine("", 2), new Body("", 2), new
	// Accessory("", 2));
	private Object isFullEngine = new Object();
	private Object isEmptyEngine = new Object();
	private Object isFullBody = new Object();
	private Object isEmptyBody = new Object();
	private Object isFullAccessory = new Object();
	private Object isEmptyAccessory = new Object();

	private Object isFullAuto = new Object();
	private Object isEmptyAuto = new Object();

	public ObjectSychronized() {
	}

	public Object getIsFullEngine() {
		return isFullEngine;
	}

	public Object getIsEmptyEngine() {
		return isEmptyEngine;
	}

	public Object getIsFullBody() {
		return isFullBody;
	}

	public Object getIsEmptyBody() {
		return isEmptyBody;
	}

	public Object getIsFullAccessory() {
		return isFullAccessory;
	}

	public Object getIsEmptyAccessory() {
		return isEmptyAccessory;
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
