package com.unicamp.mc322.project.game.exceptions;

import com.unicamp.mc322.project.game.entities.Pokemon;

public class InsufficientCaptureDistanceException extends IllegalArgumentException{

	public InsufficientCaptureDistanceException(){
		super();
	}

	public InsufficientCaptureDistanceException(String message){
		super(message);
	}

	public InsufficientCaptureDistanceException(Throwable cause){
		super(cause);
	}

	public InsufficientCaptureDistanceException(String message, Throwable cause){
		super(message, cause);
	}

	public void printRequiredCaptureDistance(Pokemon pk){
		System.out.println("Distância necessária para captura "+ pk.getCaptureDistance());
	}

	public void printCurrentDistance(double distance){
		System.out.println("Distância atual "+ distance);
	}
}