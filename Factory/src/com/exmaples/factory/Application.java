package com.exmaples.factory;

import java.util.concurrent.ExecutionException;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		// ExecutorService pool = Executors.newCachedThreadPool();
		// BodyCreator creator = new BodyCreator("Body");
		// Storage<Engine> e = new Storage<>(100);
		// Supplier<Body> s1 = new Supplier<Body>("body", creator);
		// Supplier<Body> s2 = new Supplier<Body>("body", creator);
		// List<Supplier<Body>> list = new ArrayList<>();
		// list.add(s1);
		// list.add(s2);
		// int n = 1;
		// Order o = new Order("", 10);
		// Performer<Engine> r = new Performer<Engine>();
		// r.setOrder(o);
		//
		// EngineCreator create = new EngineCreator("Engine");
		// r.loadSuppliers(create);
		// r.setSuppliers();
		// r.getMapOne();
		//
		// System.out.println(r.getMapOne().values());
		// for (Supplier<Engine> supplier : r.getMapOne().keySet()) {
		//
		// TransferforSupplierRunnable<Engine> items = new
		// TransferforSupplierRunnable<Engine>(supplier, e,
		// r.getMapOne().get(supplier));
		// Future<Storage<Engine>> result = pool.submit(items, e);
		// e = result.get();
		//
		// }
		// System.out.println(e.getItemList());
		// System.out.println(e.getFreeSpace());
		//
		// pool.shutdown();
		WorkSpace work = new WorkSpace();
		// System.out.println(work.factory.accessory);
		// System.out.println(work.factory.engine);
		// System.out.println(work.factory.body);
		// System.out.println(work.factory.auto);
		// work.results();

	}

}