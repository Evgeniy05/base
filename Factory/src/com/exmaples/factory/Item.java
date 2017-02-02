package com.exmaples.factory;

public abstract class Item {
	private int id;
	private String name;

	public Item(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public Item() {

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
