package com.exmaples.factory;

public class Sails implements Runnable {
	private Storage<Auto> from;
	private Menedger menedger;
	private int k;

	public Sails(Storage<Auto> from, Menedger menedger, int k) {
		this.from = from;
		this.menedger = menedger;
		this.k = k;
	}

	@Override
	public void run() {
		int count = 0;
		while (count < k) {
			try {
				menedger.Sail(from.getItem());
				Thread.sleep(10);
				count++;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
