package com.exmaples.factory;

public class Supplier extends Item {
	public Supplier(String name) {
		super(name);
		this.name = name;
		id = super.getId();
		date = super.getDate();
		setStorage(name);
		flag = true;
		speed = 1000;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDate() {
		return date;
	}

	private void setStorage(String name) {
		storage = new Storage(name);
	}

	public Storage getStorage() {
		return storage;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private String name, date;
	private int id;
	private long speed;

	private Storage storage;
	private boolean flag;
}
