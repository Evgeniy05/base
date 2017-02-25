package com.exmaples.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.exmaples.factory.Accessory;
import com.exmaples.factory.Body;
import com.exmaples.factory.Engine;
import com.exmaples.factory.WorkSpace;

public class Application {

	public static void main(String args[]) throws InterruptedException {
		WorkSpace work = new WorkSpace();
		ObjectSychronized obj = new ObjectSychronized();
		// Get the ThreadFactory implementation to use
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectedExecutionHandlerImpl RejectedExecutionHandler = new RejectedExecutionHandlerImpl();
		// creating the ThreadPoolExecutor
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(25, 100, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1), threadFactory, RejectedExecutionHandler);
		// start the monitoring thread
		MyMonitorThread monitor = new MyMonitorThread(executorPool, 1);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		// submit work to the thread pool
		// for (int i = 0; i < 5; i++) {
		//
		// executorPool.execute(
		// new TaskSupplier<Engine>(work.getSupplierEngine(),
		// work.factory.getStorageEngine(), "engine" + i));
		// executorPool
		// .execute(new TaskSupplier<Body>(work.getSupplierBody(),
		// work.factory.getStorageBody(), "body" + i));
		// executorPool.execute(new
		// TaskSupplier<Accessory>(work.getSupplierAccessory(),
		// work.factory.getStorageAccessory(), "accessory" + i));
		// }
		TaskForSupplier<Engine> engine = new TaskForSupplier<Engine>(work.getSupplierEngine(),
				work.factory.getStorageEngine(), obj, "engine");
		TaskForSupplier<Body> body = new TaskForSupplier<Body>(work.getSupplierBody(), work.factory.getStorageBody(),
				obj, "body");
		TaskForSupplier<Accessory> accessory = new TaskForSupplier<Accessory>(work.getSupplierAccessory(),
				work.factory.getStorageAccessory(), obj, "accessory");
		WorkerThread worker = new WorkerThread(work, "car", obj);
		Sails sail = new Sails(work, obj, "sail");
		for (int j = 0; j < 2; j++) {
			executorPool.execute(engine);
		}
		for (int i = 0; i < 2; i++) {

			executorPool.execute(body);

		}

		for (int k = 0; k < 2; k++) {

			executorPool.execute(accessory);
		}
		Thread.sleep(10000);
		for (int l = 0; l < 2; l++) {

			// executorPool.execute(
			// new TaskSupplier<Engine>(work.getSupplierEngine(),
			// work.factory.getStorageEngine(), "engine" + j));
			// executorPool
			// .execute(new TaskSupplier<Body>(work.getSupplierBody(),
			// work.factory.getStorageBody(), "body" + j));
			// executorPool.execute(new
			// TaskSupplier<Accessory>(work.getSupplierAccessory(),
			// work.factory.getStorageAccessory(), "accessory" + j));
			executorPool.execute(worker);
		}
		for (int q = 0; q < 2; q++) {
			executorPool.execute(sail);
		}

		System.out.println("y");
		// submit work to the thread pool
		// for (int i = 0; i < 1; i++) {
		// executorPool.execute(new WorkerThread(work, "car" + i));
		// work.factory.getStorageEngine().addItem(new Engine("", 1));
		// work.factory.getStorageBody().addItem(new Body("", 1));
		// work.factory.getStorageAccessory().addItem(new Accessory("", 1));
		// System.out.println(work.factory.getStorageEngine().getItem().getId());
		// }
		// shut down the pool

		// shut down the monitor thread
		Thread.sleep(30000);

		executorPool.shutdown();
		monitor.shutdown();
		// executorPool.remove(engine);
		// executorPool.remove(body);
		// executorPool.remove(accessory);
		// executorPool.remove(worker);
		// executorPool.remove(sail);

	}

}
