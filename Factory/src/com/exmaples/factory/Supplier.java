package com.exmaples.factory;

public class Supplier extends Storage {

	public Supplier(String nName) {
		name = nName;
		flag = true;
		speed = 10;
	}

	public Supplier() {
		this("Supplier#");
	}

	@Override
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

	private long speed;
	private boolean flag;
	private String name;

}
