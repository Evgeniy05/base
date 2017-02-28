package com.exmaples.threads;

import com.exmaples.factory.Accessory;
import com.exmaples.factory.Auto;
import com.exmaples.factory.Body;
import com.exmaples.factory.Engine;
import com.exmaples.factory.WorkSpace;
import com.exmaples.factory.Worker;

public class WorkerThread implements Runnable {
	private ObjectSychronized obj;
	private WorkSpace work;
	private String command;
	private boolean on = false;
	private boolean off = false;

	public WorkerThread(WorkSpace work, String command, ObjectSychronized obj) {
		this.command = command;
		this.work = work;
		this.obj = obj;
		setOn();
	}

	public void setOn() {
		on = true;
		off = false;
	}

	public void setOff() {
		on = false;
		off = true;
	}

	@Override
	public void run() {
		int count = 0;
		// System.out.println(work.factory.getHeadWorker().getListWorkers().size());
		// while (on) {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " End.");
		count++;
	}
	// }

	private void processCommand() {
		try {
			Worker worker = work.factory.getHeadWorker().getListWorkers().pollFirst();
			work.factory.getHeadWorker().getListWorkers().addLast(worker);

			// System.out.println(work.factory.getStorageAuto().getValue());
			setItem(worker);
			Auto car = worker.createCar();
			addAuto(car);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addAuto(Auto car) throws InterruptedException {

		synchronized (this) {
			if (work.factory.getStorageAuto().getValue() == work.factory.getStorageAuto().getSize()) {
				synchronized (obj.getIsFullAuto()) {
					while (work.factory.getStorageAuto().getValue() >= work.factory.getStorageAuto().getSize()) {
						obj.getIsFullAuto().wait();

					}
				}
			}
			work.factory.getStorageAuto().addItem(car);
			System.out.println(work.factory.getStorageAuto().getValue());
		}

		synchronized (obj.getIsEmptyAuto()) {
			obj.getIsEmptyAuto().notify();
		}
	}

	public void setItem(Worker worker) throws InterruptedException {
		System.out.println(work.factory.getStorageEngine().getValue());
		System.out.println(work.factory.getStorageBody().getValue());
		System.out.println(work.factory.getStorageAccessory().getValue());

		synchronized (this) {
			if (work.factory.getStorageEngine().getValue() == 0) {
				synchronized (obj.getIsEmptyEngine()) {
					while (work.factory.getStorageEngine().getValue() < 1) {
						obj.getIsEmptyEngine().wait();
					}
				}
			}
			if (work.factory.getStorageBody().getValue() == 0) {
				synchronized (obj.getIsEmptyBody()) {
					while (work.factory.getStorageBody().getValue() < 1) {
						obj.getIsEmptyBody().wait();
					}
				}
			}
			if (work.factory.getStorageAccessory().getValue() == 0) {
				synchronized (obj.getIsEmptyAccessory()) {
					while (work.factory.getStorageAccessory().getValue() < 1) {
						obj.getIsEmptyAccessory().wait();
					}
				}
			}
			final Engine value1 = work.factory.getStorageEngine().getItem();
			System.out.println(value1);
			worker.setEngine(value1);
			final Body value2 = work.factory.getStorageBody().getItem();
			System.out.println(value2);
			// valueB = work.factory.getStorageBody().getValue();
			worker.setBody(value2);
			final Accessory value3 = work.factory.getStorageAccessory().getItem();
			System.out.println(value3);
			worker.setAccessory(value3);
			System.out.println(work.factory.getStorageEngine().getValue());
			System.out.println(work.factory.getStorageBody().getValue());
			System.out.println(work.factory.getStorageAccessory().getValue());

		}
		{
			synchronized (obj.getIsFullEngine()) {
				obj.getIsFullEngine().notifyAll();
			}
			synchronized (obj.getIsFullBody()) {
				obj.getIsFullBody().notifyAll();
			}
			synchronized (obj.getIsFullAccessory()) {
				obj.getIsFullAccessory().notifyAll();
			}
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}