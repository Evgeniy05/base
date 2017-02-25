package com.exmaples.factory;

import java.util.LinkedList;

public class HeadMenedger {
	private LinkedList<Menedger> listMenedger = new LinkedList<>();
	private int menedgers = Integer.parseInt(Property.getConfig().get((Property.MENEDGERS)));

	public HeadMenedger() {

		loadMenedgers();

	}

	public LinkedList<Menedger> getListMenedger() {
		return listMenedger;
	}

	public void loadMenedgers() {
		for (int i = 0; i < menedgers; i++) {
			Menedger menedger = new Menedger();
			listMenedger.add(menedger);
		}
	}

}
