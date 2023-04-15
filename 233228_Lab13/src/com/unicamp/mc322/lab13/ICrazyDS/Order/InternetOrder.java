package com.unicamp.mc322.lab13.ICrazyDS.Order;

import com.unicamp.mc322.lab13.ICrazyDS.PersonPT;

public class InternetOrder extends Order {

	private final int CUSTOM_PRIORITY = 1;
	
	public InternetOrder(PersonPT client, String id) {
		
		super(client, id);
	}
	
	public int getCustomPriority() {
		return this.CUSTOM_PRIORITY;
	}
}
