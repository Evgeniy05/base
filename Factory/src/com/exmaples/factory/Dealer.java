package com.exmaples.factory;

public class Dealer {
	public Dealer(String name) {
		id = 0;
		;
		this.name = name;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private int id;
	private String name;
	private static int nextId = 1;
}
