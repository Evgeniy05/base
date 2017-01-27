package com.exmaples.factory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int count = 0;
		ExecutorService es = Executors.newSingleThreadExecutor();

		Factory factory = new Factory();
		// while (count < 100) {
		// Future<Supplier> result = es.submit(new
		// ItemCreator(factory.supplierEngine));
		// count++;
		//
		// // factory.supplierEngine.setFlag(false);
		// System.out.println(result.get().getStorage().getStorage().mappingCount());
		// System.out.println(factory.supplierBody.getStorage().getStorage());
		// System.out.println(factory.worker.getStorage().getStorage());
		// System.out.println(factory.dealer.getStorage().getValue());
		// System.out.println(factory.dealer.getStorage().getStorage());
		// System.out.println(factory.dealer.getResultSails());
		System.out.println(Factory.getStorage().get(Factory.getNameEngine()).getStorage());
		System.out.println(Factory.getStorage().get(Factory.getNameBody()).getStorage());
		System.out.println(Factory.getStorage().get(Factory.getNameAccessory()).getStorage());
	}

}
