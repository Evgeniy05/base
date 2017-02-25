
package com.exmaples.threads;

import java.util.ArrayList;
import java.util.List;

import com.exmaples.factory.WorkSpace;

public class Sails implements Runnable {

	private String command;
	private WorkSpace work;
	private ObjectSychronized obj;
	private List<Integer> sails = new ArrayList<>();

	public Sails(WorkSpace work, ObjectSychronized obj, String command) {
		this.work = work;
		this.command = command;
		this.obj = obj;
	}

	@Override
	public void run() {
		int count = 0;
		// System.out.println(work.getMenedgers().getListMenedger().size());
		while (count < work.getMenedgers().getListMenedger().size()) {
			try {
				System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
				processCommand();
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " End.");
				System.out.println(sails.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}

	public void processCommand() throws InterruptedException {
		// System.out.println(work.factory.getStorageAuto().getValue() + "p");
		if (work.factory.getStorageAuto().getValue() == 0) {
			synchronized (obj.getIsEmptyAuto()) {
				while (work.factory.getStorageAuto().getValue() < 1) {

					obj.getIsEmptyAuto().wait();

				}
			}
		}

		synchronized (this) {
			// System.out.println(work.factory.getStorageAuto().getValue());
			sails.add(work.factory.getStorageAuto().getItem().getId());

		}

		synchronized (obj.getIsFullAuto()) {
			obj.getIsFullAuto().notifyAll();
		}
	}
}
