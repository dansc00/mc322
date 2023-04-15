package com.unicamp.mc322.lab13.ICrazyDS.Exceptions;

public class EmptyQueueException extends NullPointerException {

	public EmptyQueueException() {
		super();
	}
	
	public EmptyQueueException(String s) {
		super(s);
	}
}
