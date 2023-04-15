package com.unicamp.mc322.project.game.exceptions;

public class InvalidInputOptionException extends IllegalArgumentException{

	public InvalidInputOptionException(){
		super();
	}

	public InvalidInputOptionException(String message){
		super(message);
	}

	public InvalidInputOptionException(Throwable cause){
		super(cause);
	}

	public InvalidInputOptionException(String message, Throwable cause){
		super(message, cause);
	}
}