package com.exmaples.threads;

import java.util.concurrent.Callable;

public class CreateTask implements Callable<Queue> {
	private Task task;
	private Queue queue = new Queue();

	public CreateTask() {

	}

	@Override
	public Queue call() {
		int count = 0;
		// while (count < 5)
		{
			try {
				task = new Task();
				queue.push(task);
				Thread.sleep(1000);
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queue;

	}
}
