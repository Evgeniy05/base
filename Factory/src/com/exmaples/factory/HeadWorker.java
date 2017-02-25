package com.exmaples.factory;

import java.util.LinkedList;

public class HeadWorker {
	private int numberWorkers = Integer.parseInt(Property.getConfig().get((Property.WORKERS)));

	private LinkedList<Worker> listWorkers = new LinkedList<>();

	public HeadWorker() {
		loadWorkers();

	}

	public void loadWorkers() {
		for (int i = 0; i < numberWorkers; i++) {
			listWorkers.add((new Worker()));
		}
	}

	public LinkedList<Worker> getListWorkers() {
		return listWorkers;
	}

}
