package com.exmaples.factory;

public class Item {
	public Item(int id,String name,Supplier supplier,long date) {
		setId(id);
		setName(name);
		setSupplier(supplier);
		setDate(date);
	}
	
 private int id;
 private String name;
 private Supplier supplier;
 private long date;
public int getId() {
	return id;
}
private void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getDate() {
	return date;
}
private void setDate(long date) {
	this.date = date;
}
public Supplier getSupplier() {
	return supplier;
}
private void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

  
  
  
  
  
  
}
