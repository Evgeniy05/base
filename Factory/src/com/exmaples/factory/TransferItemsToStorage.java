package com.exmaples.factory;

public class TransferItemsToStorage<T extends Item> implements Runnable {
	private Storage<T> from;
	private Place to;

	public TransferItemsToStorage(Storage<T> from, Place to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		try {

			to.getItems().put(from.getItem().getName(), from.getItem());
			Thread.sleep(0);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
