package com.exmaples.factory;

import java.awt.EventQueue;

abstract class SwingWorkerTask implements Runnable {
	public abstract void work() throws InterruptedException;

	public void init() {
	}

	public void update() {
	}

	public void finish() {
	}

	private void doInit() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				init();
			}
		});
	}

	protected final void doUpdate() {
		if (done)
			return;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				update();
			}
		});
	}

	private void doFinish() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				finish();
			}
		});
	}

	@Override
	public final void run() {
		doInit();
		try {
			done = false;
			work();
		} catch (InterruptedException ex) {
		} finally {
			done = true;
			doFinish();
		}
	}

	private boolean done;
}
