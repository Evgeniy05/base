package com.exmaples.factory;

public class Supplier<T extends Item> {
	private String name;
	private ItemCreator<T> creator;
	private long speed;

	public Supplier(String name, ItemCreator<T> creator) {
		this.name = name;
		this.creator = creator;
		this.speed = 100;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public Supplier(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public T createNewItem() {
		T item = creator.create();
		return item;
	}

}