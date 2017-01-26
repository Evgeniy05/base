// package com.exmaples.factory;
//
// import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ExecutorService;
//
// public class SupplierItemCreator implements
// Callable<ConcurrentHashMap<String, Item>> {
// public SupplierItemCreator(Factory factory, String detail, ExecutorService
// pool) {
// this.factory = factory;
// this.pool = pool;
// this.name = detail;
// }
//
// private int count;
// private Factory factory;
// private ExecutorService pool;
// private String name;
// private Supplier supplier;
//
// @Override
// public ConcurrentHashMap<String, Item> call() {
// try {
// transfer(Supplier, Storage, Item);
// transfer(Storage, Worker, Item);
// craete(Item1, Item2, Item3);
// transfer(Worker, Storage, Car);
// transfer(Storage, Delear, Car);
// transfer(Delear, Sorage, Car);
// List<Supplier> suppliers = factory.getListSupplier(name);
// for (Supplier supplier : suppliers) {
// factory.createItem(supplier);
// list.put(name, factory.getStorages().get(name).getItem(name));
// }
// } catch (InterruptedException e) {
// }
// return list;
//
// }
//
// private ConcurrentHashMap<String, Item> list = new ConcurrentHashMap<>();
// }
