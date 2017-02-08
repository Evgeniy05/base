package com.exmaples.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadWorker {
	private List<Place> assemblyShop = new ArrayList<>();
	private Order order;
	private int qitem;
	private int numberWorkers = Integer.parseInt(Property.getConfig().get((Property.WORKERS)));
	private Map<Place, Integer> task = new HashMap<>();
	private int ostatok;

	public HeadWorker() {

	}

	public List<Place> getAssemblyShop() {
		return assemblyShop;
	}

	public void loadWorkers() {
		for (int i = 0; i < numberWorkers; i++) {
			assemblyShop.add(new Place(new Worker()));
		}
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

	public Map<Place, Integer> getTask() {
		return task;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setWorkers() {

		if (order.getQuantaty() <= getAssemblyShop().size()) {
			int n = order.getQuantaty();
			qitem = 1;
			for (int i = 0; i < n; i++) {
				// System.out.println(getListWorkers().get(i));
				task.put(getAssemblyShop().get(i), qitem);
			}
		} else {

			if (ostatok(order.getQuantaty(), getAssemblyShop().size()) == false) {
				qitem = order.getQuantaty() / getAssemblyShop().size();
				for (Place place : getAssemblyShop()) {
					task.put(place, qitem);
				}
			} else {
				qitem = order.getQuantaty() / getAssemblyShop().size();
				for (Place place : getAssemblyShop()) {
					task.put(place, qitem);
				}
				ostatok = order.getQuantaty() - qitem * getAssemblyShop().size();
				for (int i = 0; i < ostatok; i++) {
					Integer value = 0;
					value = task.get(getAssemblyShop().get(i)) + 1;
					task.put(getAssemblyShop().get(i), value);
				}
			}
		}
	}
}
