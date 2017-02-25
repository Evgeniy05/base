// package com.exmaples.threads;
//
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.TimeUnit;
//
// import com.exmaples.factory.Accessory;
// import com.exmaples.factory.Body;
// import com.exmaples.factory.Engine;
// import com.exmaples.factory.HeadMenedger;
// import com.exmaples.factory.Menedger;
// import com.exmaples.factory.Supplier;
// import com.exmaples.factory.WorkSpace;
// import com.exmaples.factory.Worker;
//
// public class HeadTask implements Runnable {
// WorkSpace work;
// Worker worker = null;
// ExecutorService sh = Executors.newFixedThreadPool(34);
// HeadMenedger headMenedger = null;
// Collection<TaskForSupplier<Accessory>> taskForSupplierAccessory = new
// ArrayList<>();
// Collection<TaskForSupplier<Body>> taskForSupplierBody = new ArrayList<>();
// Collection<TaskForSupplier<Engine>> taskForSupplierEngine = new
// ArrayList<>();
// Collection<TaskPartOne> taskPartOne = new ArrayList<>();
// Collection<TaskPartTwo> taskPartTwo = new ArrayList<>();
// Collection<Sails> taskSails = new ArrayList<>();
// Collection<?> task = new ArrayList<>();
//
// public HeadTask(WorkSpace work) {
// this.work = work;
// this.headMenedger = work.getMenedgers();
// }
//
// @Override
// public void run() {
// int count = 0;
//
// for (Supplier<Engine> supplier : work.getSupplierEngine().getListSuppliers())
// {
//
// taskForSupplierEngine.add(new TaskForSupplier<Engine>(supplier,
// work.factory.getStorageEngine()));
// }
//
// System.out.println(work.getSupplierEngine().getListSuppliers().size());
// for (Supplier<Body> supplier : work.getSupplierBody().getListSuppliers()) {
//
// taskForSupplierBody.add(new TaskForSupplier<Body>(supplier,
// work.factory.getStorageBody()));
// }
// for (Supplier<Accessory> supplier :
// work.getSupplierAccessory().getListSuppliers()) {
//
// taskForSupplierAccessory.add(new TaskForSupplier<Accessory>(supplier,
// work.factory.getStorageAccessory()));
// }
// for (int i = 0; i < headMenedger.getListMenedger().size(); i++) {
// TaskPartOne order = new TaskPartOne();
// headMenedger.getListMenedger().get(i).setOrder(order);
// headMenedger.getListTask().add(order);
// taskPartOne.add(order);
// }
//
// for (Worker worker : work.factory.getHeadWorker().getListWorkers()) {
// while (taskPartOne.iterator().hasNext()) {
// TaskPartOne task = taskPartOne.iterator().next();
// taskPartOne.remove(task);
// task.setWorker(worker);
//
// taskPartTwo.add(new TaskPartTwo(work.factory.getStorageAccessory(),
// work.factory.getStorageBody(),
// work.factory.getStorageEngine(), work.factory.getStorageAuto(), task));
//
// }
// }
// for (Menedger menedger : headMenedger.getListMenedger()) {
// taskSails.add(new Sails(work.factory.getStorageAuto(), menedger));
// }
//
// // task.addAll((Collection<?>) taskForSupplierAccessory);
// try {
// sh.invokeAll(taskForSupplierAccessory, 1000, TimeUnit.SECONDS);
// sh.invokeAll(taskForSupplierBody, 1000, TimeUnit.SECONDS);
// sh.invokeAll(taskForSupplierEngine, 1000, TimeUnit.SECONDS);
// sh.invokeAll(taskPartTwo, 1000, TimeUnit.SECONDS);
// sh.invokeAll(taskSails, 1000, TimeUnit.SECONDS);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// count++;
// taskForSupplierEngine.clear();
// taskForSupplierBody.clear();
// taskForSupplierAccessory.clear();
// taskPartTwo.clear();
// try {
// sh.shutdown();
// sh.awaitTermination(10, TimeUnit.SECONDS);
//
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
// }
