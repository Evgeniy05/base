// package com.exmaples.factory;
//
// public class FactoryRunnable implements Runnable {
//
// public FactoryRunnable(Factory f, Supplier s, long speed, boolean flag) {
// factory = f;
// supplier = s;
// millis = speed;
// begin = flag;
// }
//
// @Override
// public void run() {
// try {
// while (begin == true)
// factory.createItemAccessory(supplier);
// factory.createItemBody(supplier);
// factory.createItemEngine(supplier);
// Thread.sleep(millis);
// } catch (InterruptedException e) {
// }
// }
//
// private Factory factory;
// private Supplier supplier;
// private String name;
// private long millis;
// private boolean begin;
// }
