package com.exmaples.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Item {
	private String name, date;
	private int id, idInt, nextDate, freeValue;
	private long size;
	private Supplier supplier;
	private static int nextId = 1;
	private Engine engine;
	private Body body;
	private Accessory accessory;
	private static Map<String, Integer> key = new HashMap<>();

	public Item(Supplier supplier) {
		id = 0;
		idInt = 0;
		date = "";
		setName(supplier.getName());
		setId();
		setDate();

	}

	public Item(long size, String name) {
		this.name = name;
		this.size = size;
		id = 0;
		idInt = 0;
		date = "";
		setId();
		setDate();

	}

	public Item(String name) {
		this.name = name;
		id = 0;
		idInt = 0;
		date = "";
		setId();
		setDate();

	}

	public Item() {
		name = "";
		id = 0;
		idInt = 0;
		date = "";
		setId();
		setDate();

	}

	public Item(Engine engine, Body body, Accessory accessory) {
		this.engine = engine;
		this.body = body;
		this.accessory = accessory;
		name = Factory.getNameAuto();
		id = 0;
		idInt = 0;
		setId();
		setDate();

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

	private void setId() {
		id = nextId;
		nextId++;
	}

	private void setDate() {
		GregorianCalendar s = new GregorianCalendar();
		int year = s.get(Calendar.YEAR);

		if (key == null || key.get(this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/") == null
				|| key.isEmpty()) {
			key.put(this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/", 1);
			idInt = 1;
			String idStr = this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/"
					+ String.valueOf(idInt);
			date = idStr;
		} else {
			nextDate = key.get(this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/") + 1;
			idInt = nextDate;
			key.put(this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/", nextDate);
			String idStr = this.getClass().getSimpleName() + " " + name + "-" + year + "-" + "/"
					+ String.valueOf(idInt);
			date = idStr;
		}
		// System.out.println(date);
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

	// public void setFreeValue(int freeValue) {
	// this.freeValue = freeValue;
	// }
	//
	// public int getFreeValue() {
	// return freeValue;
	// }

}
