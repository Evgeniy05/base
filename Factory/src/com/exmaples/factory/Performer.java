package com.exmaples.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Performer<T extends Item> {
	private final String engine = "Engine";
	private final String body = "Body";
	private final String accessory = "Accessory";
	private final int suppliersEngine = Integer.parseInt(Property.getConfig().get((Property.ENGINE_SUPPLIERS)));
	private final int suppliersBody = Integer.parseInt(Property.getConfig().get((Property.BODY_SUPPLIERS)));
	private final int suppliersAccessory = Integer.parseInt(Property.getConfig().get(Property.ACCESSORY_SUPPLIERS));
	private Order order;
	private int qitem, ostatok;
	private Map<Supplier<T>, Integer> workMapOne = new HashMap<>();
	private List<Supplier<T>> listSuppliers = new ArrayList<>();

	public Performer() {
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean ostatok(int order, int performers) {
		boolean ostatok = false;
		int qitem = order / performers;
		if (order - qitem * performers == 0) {
		} else {
			ostatok = true;
		}
		return ostatok;
	}

	public Map<Supplier<T>, Integer> getMapOne() {
		return workMapOne;
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

	public List<Supplier<T>> getListSuppliers() {
		return listSuppliers;
	}

	public void setSuppliers() {

		if (order.getQuantaty() <= getListSuppliers().size()) {

			int n = order.getQuantaty();
			qitem = 1;
			for (int i = 0; i < n; i++) {
				// System.out.println(getListSuppliers().get(i));
				workMapOne.put(getListSuppliers().get(i), qitem);
			}
		} else {
			if (ostatok(order.getQuantaty(), getListSuppliers().size()) == false) {
				qitem = order.getQuantaty() / getListSuppliers().size();
				for (Supplier<T> supplier : getListSuppliers()) {
					workMapOne.put(supplier, qitem);
				}
			} else {
				qitem = order.getQuantaty() / getListSuppliers().size();
				for (Supplier<T> supplier : getListSuppliers()) {
					workMapOne.put(supplier, qitem);
				}
				ostatok = order.getQuantaty() - qitem * getListSuppliers().size();
				for (int i = 0; i < ostatok; i++) {
					Integer value = 0;
					value = workMapOne.get(getListSuppliers().get(i)) + 1;
					workMapOne.put(getListSuppliers().get(i), value);
				}
			}
		}
	}
}
