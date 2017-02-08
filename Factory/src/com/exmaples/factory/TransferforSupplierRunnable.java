package com.exmaples.factory;

public class TransferforSupplierRunnable<T extends Item> implements Runnable {
	private T item;
	private int k;
	private Supplier<T> supplier;
	private Storage<T> to;

	public TransferforSupplierRunnable(Supplier<T> supplier, Storage<T> to, int k) {
		this.supplier = supplier;
		this.to = to;
		this.k = k;
	}

	@Override
	public void run() {
		try {
			int count = 0;
			while (count < k) {
				item = supplier.createNewItem();
				to.addItem(item);
				Thread.sleep(supplier.getSpeed());
				count++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}