package com.exmaples.factory;

public abstract class ItemCreator<T extends Item> {

	private String name;
	private Integer id = HashCode() + 1;

	public ItemCreator(String name) {
		this.name = name;
	}

	public synchronized Integer generateId() {
		return this.id++;
	}

	public abstract T create();

	public String getName() {
		return name;
	}

	public Integer HashCode() {
		Integer code = hashCode();
		return code;
	}
}
