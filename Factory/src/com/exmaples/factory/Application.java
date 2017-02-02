package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		ExecutorService pool = Executors.newCachedThreadPool();
		BodyCreator creator = new BodyCreator("Body");
		Storage<Engine> e = new Storage<>(100);
		Supplier<Body> s1 = new Supplier<Body>("body", creator);
		Supplier<Body> s2 = new Supplier<Body>("body", creator);
		List<Supplier<Body>> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		int n = 1;
		Order o = new Order("", 90);
		Performer<Engine> r = new Performer<Engine>();
		r.setOrder(o);
		Engine b = new Engine("Engine", 1);
		EngineCreator create = new EngineCreator("Engine");
		r.loadSuppliers(b, create);
		r.setSuppliers();
		r.getMapOne();

		System.out.println(r.getMapOne().values());
		for (Supplier<Engine> supplier : r.getMapOne().keySet()) {

			TransferforSupplierRunnable<Engine> items = new TransferforSupplierRunnable<Engine>(supplier, e,
					r.getMapOne().get(supplier));
			Future<Storage<Engine>> result = pool.submit(items, e);
			e = result.get();

		}
		System.out.println(e.getItemList());
		System.out.println(e.getFreeSpace());

		pool.shutdown();
		// WorkSpace work = new WorkSpace();
		// System.out.println(work.factory.storages.get(Item.ENGINE).getStorage());
		// System.out.println(work.factory.storages.get(Item.BODY).getStorage());
		// System.out.println(work.factory.storages.get(Item.ACCESSORY).getStorage());
		// System.out.println(work.factory.storages.get(Auto.AUTO).getStorage().size());
		// work.results();
		// ItemCreator(factory.supplierEngine));
		// count++;
		//
		// // factory.supplierEngine.setFlag(false);

		// System.out.println(factory.supplierBody.getStorage().getStorage());
		// System.out.println(factory.getStorage().values().iterator().next().getStorage());

		// System.out.println(Factory.getStorage().get(Factory.AUTO));

	}

}