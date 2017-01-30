package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Auto extends Item {
	public static final String AUTO = "Auto";
	{
		name = AUTO + "Car";

	}

	public Auto(Engine engine, Body body, Accessory accessory) {
		description.add(engine);
		description.add(body);
		description.add(accessory);
	}

	public String getName() {
		return name;
	}

	public List<Item> getDescription() {
		return description;
	}

	private String name;
	private List<Item> description = new ArrayList<>();

}
