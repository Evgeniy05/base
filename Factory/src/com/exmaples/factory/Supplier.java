package com.exmaples.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Supplier {
	public Supplier(String name) {
		id = 0;
		date = "";
		setId();
		setDate();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId;
		nextId++;
	}

	public String getName() {
		return name;
	}

	private void setDate() {
		GregorianCalendar s = new GregorianCalendar();
		int year = s.get(Calendar.YEAR);
		String idName = this.getName();
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

	public String getDate() {
		return date;
	}

	private int id, idInt, nextDate;
	private String name, date;
	private static int nextId = 1;
	public static Map<String, Integer> key = new HashMap<>();
}
