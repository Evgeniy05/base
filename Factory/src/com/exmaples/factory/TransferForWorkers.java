package com.exmaples.factory;

public class TransferForWorkers implements Runnable {
	private Worker worker;
	private Storage<Engine> engine;
	Storage<Body> body;
	Storage<Accessory> accessory;
	Storage<Auto> auto;
	int k;

	@SuppressWarnings("unchecked")
	public TransferForWorkers(Worker worker, Object engine, Object body, Object accessory, Object auto, Object k) {
		this.worker = worker;
		this.engine = (Storage<Engine>) engine;
		this.body = (Storage<Body>) body;
		this.accessory = (Storage<Accessory>) accessory;
		this.auto = (Storage<Auto>) auto;
		this.k = (int) k;
	}

	@Override
	public void run() {
		try {
			int count = 0;
			while (count < k) {
				worker.setEngine(engine.getItem());
				worker.setBody(body.getItem());
				worker.setAccessory(accessory.getItem());
				Auto car = new Auto(worker.getEngine(), worker.getBody(), worker.getAccessory());
				auto.addItem(car);
			}
		} catch (InterruptedException e) {
		}
	}
}
