package com.exmaples.factory;

public class Application {

	public static void main(String[] args) {
		Factory factory = new Factory();
		// System.out.println(factory.supplierBody.getStorage().getStorage());
		System.out.println(factory.worker.getStorage().getStorage());
		System.out.println(factory.dealer.getStorage().getValue());
		System.out.println(factory.dealer.getStorage().getStorage());
		// System.out.println(Factory.getStorage().get(Factory.getNameEngine()).getStorage());
		// System.out.println(Factory.getStorage().get(Factory.getNameBody()).getStorage());
		// System.out.println(Factory.getStorage().get(Factory.getNameAccessory()).getStorage());
	}

}
