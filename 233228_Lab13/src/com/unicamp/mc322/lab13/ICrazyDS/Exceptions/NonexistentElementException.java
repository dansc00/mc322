package com.unicamp.mc322.lab13.ICrazyDS.Exceptions;

import com.unicamp.mc322.lab13.ICrazyDS.Order.IOrder;

public class NonexistentElementException extends NullPointerException {

	public NonexistentElementException() {
		super();
	}
	
	public NonexistentElementException(String s) {
		super(s);
	}
	
	public IOrder getNonexistentElement(IOrder ne) {
		return ne;
	}
}
