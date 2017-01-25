package com.exmaples.factory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class SupplierItemCreater implements Callable<List<Item>> {
	public SupplierItemCreater(Factory factory, String Item, ExecutorService pool) {
		this.factory = factory;
		this.pool = pool;
		this.name = Item;
	}

	private int count;
	private Factory factory;
	private ExecutorService pool;
	private String name;

	@Override
	public List<Item> call() {
		try {
			Supplier[] suppliers = (Supplier[]) factory.getListSupplier(name).toArray();
			for (Supplier supplier : suppliers) {
				factory.createItem(supplier);
				factory.getStorages().get(name);
				SupplierItemCreater result = new SupplierItemCreater();
				FutureTask<List<Item>> task = new FutureTask<List<Item>>();

			}
		} catch (InterruptedException e) {
		}

	}
}
