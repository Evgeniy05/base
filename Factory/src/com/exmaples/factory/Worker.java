package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	public Worker(int id) {
		this.id = id;
	}

	public Item getItem() {
		listItem.add(getWarehouseAccessory.getItems());
		listItem.add(e);
		listItem.add(e);
	}

	public Auto createCar(){
		
		Auto car= new Auto(setId()),listItem..,getbody,getaccessory);
		return car;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = nextId;
		nextId++;
	}

	private int id;
	private List<Item> listItem = new ArrayList<>(3);
	private static int nextId = 1;
}
