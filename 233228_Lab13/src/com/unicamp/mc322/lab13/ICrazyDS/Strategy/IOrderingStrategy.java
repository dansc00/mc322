package com.unicamp.mc322.lab13.ICrazyDS.Strategy;

import com.unicamp.mc322.lab13.ICrazyDS.Order.IOrder;

public interface IOrderingStrategy {

	public double calculatePriorityPoints(IOrder p);
	public double getPoints();
}
