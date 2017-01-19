package com.exmaples.factory;

public class Supplier {
	public Supplier(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private int id;
	private String name;
}
