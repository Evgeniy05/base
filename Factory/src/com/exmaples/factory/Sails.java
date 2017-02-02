package com.exmaples.factory;

public class Sails implements Runnable {
	private Storage from;
	private Menedger menedger;

	public Sails(Storage from, Menedger menedger) {

	}

	@Override
	public void run() {

		while (true) {
			try {
				menedger.Sail((Auto) from.getItem(Auto.AUTO));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
