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
		// Create factory(have four storage-Engine,Body,Accessory,Auto) with
		// workers plus Suppliers;
		// System.out.println(work.factory.getStorageAccessory().getName());
		ObjectSychronized obj = new ObjectSychronized();
		// Create monitors for workerThreads
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
		TaskForSupplier<Engine> engine = new TaskForSupplier<Engine>(work.getSupplierEngine(),
				work.factory.getStorageEngine(), obj, "engine");
		// Task for threads create engine
		TaskForSupplier<Body> body = new TaskForSupplier<Body>(work.getSupplierBody(), work.factory.getStorageBody(),
				obj, "body");
		// Task for threads create body
		TaskForSupplier<Accessory> accessory = new TaskForSupplier<Accessory>(work.getSupplierAccessory(),
				work.factory.getStorageAccessory(), obj, "accessory");
		// Task for threads create accessory
		WorkerThread worker = new WorkerThread(work, "car", obj);
		// Task for WorkerThreads create auto
		Sails sail = new Sails(work, obj, "sail");
		// Task for threads sail car
		for (int j = 0; j < work.getSupplierEngine().getListSuppliers().size(); j++) {
			executorPool.execute(engine);
		}
		for (int i = 0; i < work.getSupplierBody().getListSuppliers().size(); i++) {
			executorPool.execute(body);
		}

		for (int k = 0; k < work.getSupplierAccessory().getListSuppliers().size(); k++) {
			executorPool.execute(accessory);
		}
		for (int l = 0; l < work.factory.getHeadWorker().getListWorkers().size(); l++) {
			executorPool.execute(worker);
		}
		for (int q = 0; q < 1; q++) {
			executorPool.execute(sail);
		}

		executorPool.shutdown();
		monitor.shutdown();
	}

}
