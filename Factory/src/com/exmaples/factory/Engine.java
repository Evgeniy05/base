package com.exmaples.factory;

public class Engine extends Item{
 
public Engine(int id,String name,Supplier supplier,long date){
	 super(id,name,supplier,date);
	 
 }
	public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
	private int value;

}
