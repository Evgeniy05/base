package com.exmaples.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Item {
	public Item(Supplier supplier) {
		id = 0;
		idInt = 0;
		date = "";
		name = "";
		setSupplier(supplier);
		setId();
		setDate(this);

	}

	private String name, date;
	private int id, idInt, nextDate;
	private Supplier supplier;
	private static int nextId = 1;

	public int getId() {
		return id;
	}

	private void setId() {
		id = nextId;
		nextId++;
	}

	private void setDate(Item item) {
		GregorianCalendar s = new GregorianCalendar();
		int year = s.get(Calendar.YEAR);
		String idName = item.getClass().getSimpleName();
		if (key.get(idName) == null) {
			key.put(idName, 1);
			idInt = 1;
			String idStr = idName + "-" + year + "-" + "/" + String.valueOf(idInt);
			date = idStr;
		} else {
			nextDate = key.get(idName) + 1;
			idInt = nextDate;
			key.put(idName, nextDate);
			String idStr = idName + "-" + year + "-" + "/" + String.valueOf(idInt);
			date = idStr;
		}

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

	private void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public static Map<String, Integer> key = new HashMap<>();
	public static final String BODY = "Body";
	public static final String ENGINE = "Engine";
	public static final String ACCESSORY = "Accessory";
}
