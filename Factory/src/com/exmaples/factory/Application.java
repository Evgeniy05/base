package com.exmaples.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {
	public static void main(String[] args) {
		String name = "";
		Factory factory = new Factory();
		name = factory.BODY;
		ExecutorService pool = Executors.newFixedThreadPool(Integer.valueOf(Property.getConfig().get(name)));
		SupplierItemCounter counterSupplier = new SupplierItemCounter(factory, name, pool);
		Future<Integer> result = pool.submit(counterSupplier);

	}

}
