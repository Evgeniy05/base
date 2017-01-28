package com.exmaples.factory;

public class Item {
	private String name;
	private String date;
	private int id;
	private long size;
	private Supplier supplier;
	private static int nextId = 1;
	private Engine engine;
	private Body body;
	private Accessory accessory;
	{
		id = nextId;
		nextId++;
	}

	public Item() {
		this("Item#");
	}

	public Item(Supplier aSupplier) {
		supplier = aSupplier;
	}

	public Item(long aSize, String aName) {
		name = aName;
		size = aSize;
	}

	public Item(String aName) {
		name = aName;
	}

	public Item(Engine aEngine, Body aBody, Accessory aAccessory) {
		engine = aEngine;
		body = aBody;
		accessory = aAccessory;
		this.name = Factory.AUTO;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

}
