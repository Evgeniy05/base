package com.exmaples.threads;

import com.exmaples.factory.Item;
import com.exmaples.factory.Performer;
import com.exmaples.factory.Storage;
import com.exmaples.factory.Supplier;

public class TaskForSupplier<T extends Item> implements Runnable {
	private T item;
	private Supplier<T> supplier;
	private Storage<T> to;
	private String command;
	private Performer<T> performer;
	private ObjectSychronized obj;

	public TaskForSupplier(Performer<T> performer, Storage<T> to, ObjectSychronized obj, String command) {
		this.command = command;
		this.obj = obj;
		this.performer = performer;
		this.to = to;
	}

	public void processCommand() throws InterruptedException {
		switch (to.getName()) {
		case "Engine":
			synchronized (this) {
				if (to.getValue() == to.getSize()) {
					while (to.getValue() >= to.getSize()) {

						synchronized (obj.getIsFullEngine()) {
							obj.getIsFullEngine().wait();
						}
					}
				}

				supplier = performer.getListSuppliers().pollFirst();
				performer.getListSuppliers().addLast(supplier);
				item = supplier.createNewItem();
				to.addItem(item);
				Thread.sleep(supplier.getSpeed());
			}

			synchronized (obj.getIsEmptyEngine()) {
				obj.getIsEmptyEngine().notifyAll();
			}

		case "Body":
			synchronized (this)

			{
				if (to.getValue() == to.getSize()) {
					while (to.getValue() >= to.getSize()) {

						synchronized (obj.getIsFullBody()) {
							obj.getIsFullBody().wait();
						}
					}
				}
				supplier = performer.getListSuppliers().pollFirst();
				performer.getListSuppliers().addLast(supplier);
				item = supplier.createNewItem();
				to.addItem(item);
				Thread.sleep(supplier.getSpeed());
			}
			synchronized (obj.getIsEmptyBody()) {
				obj.getIsEmptyBody().notifyAll();
			}

		case "Accessory":
			synchronized (this)

			{
				if (to.getValue() == to.getSize()) {
					while (to.getValue() >= to.getSize()) {

						synchronized (obj.getIsFullEngine()) {
							obj.getIsFullEngine().wait();
						}
					}
				}
				supplier = performer.getListSuppliers().pollFirst();
				performer.getListSuppliers().addLast(supplier);
				item = supplier.createNewItem();
				to.addItem(item);
				Thread.sleep(supplier.getSpeed());
			}

			synchronized (obj.getIsEmptyAccessory()) {
				obj.getIsEmptyAccessory().notifyAll();
			}

		}
	}

	@Override
	public void run() {

		int count = 0;
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		System.out.println(performer.getListSuppliers().size());
		// while (count < }
		{
			try {
				processCommand();
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " End.");
			count++;
		}
	}
}