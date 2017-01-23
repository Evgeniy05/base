package com.exmaples.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SupplierItemCounter implements Callable<Integer> {
	public SupplierItemCounter(Factory factory, String Item, ExecutorService pool) {
		this.factory = factory;
		this.pool = pool;
		this.name = Item;
	}

	private int count;
	private Factory factory;
	private ExecutorService pool;
	private String name;

	@Override
	public Integer call() {
		count = 0;
		try {
			List<Future<Integer>> results = new ArrayList<>();

		} catch (InterruptedException e) {
		}
		return count;
	}
}
