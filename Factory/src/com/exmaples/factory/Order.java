package com.exmaples.factory;

public class Order {
	private String customer;
	private int quantaty;
	private Integer id = 0;
	private static int nextId = 1;
	{
		id = nextId;
		nextId++;
	}

	public Order(String customer, int quantaty) {
		this.customer = customer;
		this.quantaty = quantaty;

	}

	public String getCustomer() {
		return customer;
	}

	public int getQuantaty() {
		return quantaty;
	}

	public Integer getId() {
		return id;
	}
}
