package com.unicamp.mc322.lab13.ICrazyDS.Order;

import com.unicamp.mc322.lab13.ICrazyDS.PersonPT;

public class PhysicalOrder extends Order {

	private final int CUSTOM_PRIORITY = 2;
	
	public PhysicalOrder(PersonPT p, String id) {
		
		super(p, id);
	}
	
	public int getCustomPriority() {
		return this.CUSTOM_PRIORITY;
	}
}
