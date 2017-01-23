package com.exmaples.factory;

import java.util.concurrent.Callable;

public class StorageDeatailCounter implements Callable<Integer> {
	private int count;

	@Override
	public Integer call() {
		count = 0;

		return count;
	}
}
