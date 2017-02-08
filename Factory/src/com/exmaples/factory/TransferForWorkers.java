package com.exmaples.factory;

public class TransferForWorkers implements Runnable {
	private Place place;
	Storage<Auto> auto;
	private Auto car;
	int k;

	public TransferForWorkers(Place place, Storage<Auto> auto, int k) {
		this.place = place;
		this.auto = auto;
		this.k = k;
	}

	@Override
	public void run() {
		try {
			int count = 0;
			while (count < k) {
				car = place.createCar();
				auto.addItem(car);
				Thread.sleep(10);
				count++;
			}
		} catch (InterruptedException e) {
		}
	}
}
