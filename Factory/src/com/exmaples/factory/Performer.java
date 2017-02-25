package com.exmaples.factory;

import java.util.LinkedList;

public class Performer<T extends Item> {
	private final String engine = "Engine";
	private final String body = "Body";
	private final String accessory = "Accessory";
	private final int suppliersEngine = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
	private final int suppliersBody = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
	private final int suppliersAccessory = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
	private LinkedList<Supplier<T>> listSuppliers = new LinkedList<>();

	public Performer() {
	}

	public void loadSuppliers(ItemCreator<T> creator) {
		if (creator.getName().equals(engine)) {
			for (int i = 0; i < suppliersEngine; i++) {
				listSuppliers.add(new Supplier<T>(engine, creator));
			}
		}
		if (creator.getName().equals(body)) {
			for (int i = 0; i < suppliersBody; i++) {
				listSuppliers.add(new Supplier<T>(body, creator));
			}
		}
		if (creator.getName().equals(accessory)) {
			for (int i = 0; i < suppliersAccessory; i++) {
				listSuppliers.add(new Supplier<T>(accessory, creator));
			}
		}

	}

	public LinkedList<Supplier<T>> getListSuppliers() {
		return listSuppliers;
	}

}
