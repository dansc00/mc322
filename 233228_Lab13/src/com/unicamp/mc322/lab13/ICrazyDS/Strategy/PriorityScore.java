package com.unicamp.mc322.lab13.ICrazyDS.Strategy;

import com.unicamp.mc322.lab13.ICrazyDS.Order.IOrder;

public class PriorityScore implements IOrderingStrategy{

	private double points;
	
	public PriorityScore() {
		
		this.points = 0;
	}
	
	public double getPoints(){
		return this.points;
	}
	
	public double calculatePriorityPoints(IOrder p) {
		
		this.points = (p.getClient().getAge() / 100) + ((7/100) * p.getShifts());
		p.setPriorityPoints(points);
		
		return this.getPoints();
	}
	
}
