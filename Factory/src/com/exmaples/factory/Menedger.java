package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Menedger {
	private List<Integer> carList;

	{
		name = Property.MENEDGERS;
		carList = new ArrayList<>();
	}

	public Menedger() {
		super();

	}

	public List<Integer> getCarList() {
		return carList;
	}

	public Integer getOrderCar() {
		return orderCar;
	}

	public void setOrderCar() {
		Random generator = new Random();
		this.orderCar = generator.nextInt(3);
	}

	public String getName() {
		return name;
	}

	public void Sail(Auto car) {
		getCarList().add(car.getId());
	}

	public int getResultSails() {
		return getCarList().size();
	}

	private String name;
	private int orderCar;
}
