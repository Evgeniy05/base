package com.exmaples.threads;

import java.util.Date;

class Task implements Runnable {

	public Task() {
	}

	@Override
	public void run() {
		int count = 0;
		// while (count < 1)
		{
			try {

				System.out.println("Doing a task during :  - Time - " + new Date());
				Thread.sleep(1000);
				count++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
