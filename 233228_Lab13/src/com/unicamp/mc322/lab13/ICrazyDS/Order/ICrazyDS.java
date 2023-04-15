package com.unicamp.mc322.lab13.ICrazyDS.Order;

public interface ICrazyDS {

	public void addOrder(IOrder x);
	public void remOrder(IOrder x);
	public IOrder getHigherPriority();
	public void printOrders();
}
