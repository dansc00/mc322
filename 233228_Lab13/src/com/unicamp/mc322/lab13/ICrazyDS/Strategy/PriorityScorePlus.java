// PriorityScore com incremento do tipo de pedido no cálculo da pontuação
package com.unicamp.mc322.lab13.ICrazyDS.Strategy;

import com.unicamp.mc322.lab13.ICrazyDS.Order.IOrder;

public class PriorityScorePlus implements IOrderingStrategy {
	
	private double points;
	
	public PriorityScorePlus() {
		
		this.points = 0;
	}
	
	public double getPoints() {
		return this.points;
	}
	
	public double calculatePriorityPoints(IOrder p) {
		
		this.points = (p.getClient().getAge() / 100) + ((7/100) * p.getShifts()) * p.getCustomPriority();
		p.setPriorityPoints(points);
		
		return this.getPoints();
	}

}
