package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Menedger {
	private String name;
	private static List<Integer> carList;
	private int id = 0;
	private static int nextId = 1;

	{
		id = nextId;
		nextId++;
		name = Property.MENEDGERS + String.valueOf(id);
		carList = new ArrayList<>();
	}

	public Menedger() {
	}

	public List<Integer> getCarList() {
		return carList;
	}

	public String getName() {
		return name;
	}

	public void Sail(Auto car) {

		getCarList().add(car.getId());
		System.out.println("Sail" + car.getId());
	}

	public int getResultSails() {
		return getCarList().size();
	}

}
