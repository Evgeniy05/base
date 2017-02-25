package com.exmaples.factory;

public class Factory {

	private final HeadWorker headWorker = new HeadWorker();
	private final Storage<Accessory> accessory = new Storage<Accessory>(
			Integer.parseInt(Property.getConfig().get(Property.STORAGE_ACCESSORY_SIZE)), Property.ACCESSORY);;
	private final Storage<Body> body = new Storage<Body>(
			Integer.parseInt(Property.getConfig().get(Property.STORAGE_BODY_SIZE)), Property.BODY);
	private final Storage<Engine> engine = new Storage<Engine>(
			Integer.parseInt(Property.getConfig().get(Property.STORAGE_ENGINE_SIZE)), Property.ENGINE);
	private final Storage<Auto> auto = new Storage<Auto>(
			Integer.parseInt(Property.getConfig().get(Property.STORAGE_AUTO_SIZE)), Auto.AUTO);
	public static final String AUTO = "Auto";
	public static final String WORKER = "Worker";

	public Storage<Accessory> getStorageAccessory() {
		return accessory;
	}

	public Storage<Body> getStorageBody() {
		return body;
	}

	public Storage<Engine> getStorageEngine() {
		return engine;
	}

	public Storage<Auto> getStorageAuto() {
		return auto;
	}

	public HeadWorker getHeadWorker() {
		return headWorker;
	}

}
