package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
	private Item item;
	private long speed;
	private boolean flag;
	private String name;
	private List<Integer> items;

	{
		items = new ArrayList<Integer>();
	}

	public Supplier(String nName) {
		name = nName;
		flag = true;
		speed = 10;
	}

	public Supplier() {
		this("Supplier#");
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		items.add(item.getId());
	}

	public String getName() {
		return name;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
