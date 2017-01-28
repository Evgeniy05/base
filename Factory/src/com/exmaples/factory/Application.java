package com.exmaples.factory;

import java.util.concurrent.ExecutionException;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Factory factory = new Factory();

		// ItemCreator(factory.supplierEngine));
		// count++;
		//
		// // factory.supplierEngine.setFlag(false);
		// System.out.println(result.get().getStorage().getStorage().mappingCount());
		// System.out.println(factory.supplierBody.getStorage().getStorage());
		// System.out.println(factory.getStorage().values().iterator().next().getStorage());

		// System.out.println(Factory.getStorage().get(Factory.AUTO));

	}
}