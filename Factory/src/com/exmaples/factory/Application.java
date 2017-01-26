package com.exmaples.factory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();

		Factory factory = new Factory();
		Future<Supplier> result = es.submit(new ItemCreator(factory.supplierEngine));
		Future<Supplier> result2 = es.submit(new ItemCreator(factory.supplierEngine));
		// factory.supplierEngine.setFlag(false);
		System.out.println(result2.get().getStorage().getStorage().values());
		// System.out.println(factory.supplierBody.getStorage().getStorage());
		// System.out.println(factory.worker.getStorage().getStorage());
		// System.out.println(factory.dealer.getStorage().getValue());
		// System.out.println(factory.dealer.getStorage().getStorage());
		// System.out.println(factory.dealer.getResultSails());
		// System.out.println(Factory.getStorage().get(Factory.getNameEngine()).getStorage());
		// System.out.println(Factory.getStorage().get(Factory.getNameBody()).getStorage());
		// System.out.println(Factory.getStorage().get(Factory.getNameAccessory()).getStorage());
	}

}
