package com.exmaples.factory;

import java.util.concurrent.ExecutionException;

public class Application {

	public static void main(String[] args) throws InterruptedException, ExecutionException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		WorkSpace work = new WorkSpace();
		System.out.println(work.factory.storages.get(Item.ENGINE).getStorage());
		System.out.println(work.factory.storages.get(Item.BODY).getStorage());
		System.out.println(work.factory.storages.get(Item.ACCESSORY).getStorage());
		System.out.println(work.factory.storages.get(Auto.AUTO).getStorage().size());
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