package com.exmaples.factory;

public class Item {
	private int id;
	private static int nextId = 1;

	{
		id = nextId;
		nextId++;
	}

	public int getId() {
		return id;
	}

	public static final String BODY = "Body";
	public static final String ENGINE = "Engine";
	public static final String ACCESSORY = "Accessory";

}
