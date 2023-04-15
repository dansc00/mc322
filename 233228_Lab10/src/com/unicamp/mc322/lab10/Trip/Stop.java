package com.unicamp.mc322.lab10.Trip;

import com.unicamp.mc322.lab10.user.*;

public class Stop {
	
	private Passenger p;
	private double position;
	private String option;
	
	public Stop(Passenger p, double position, String option) {
		
		this.p = p;
		this.position = position;
		this.option = option;
	}
	
	public void printDetails() {
		
		System.out.println("Mudança de passageiro "+ this.p);
		System.out.println("Parou em "+ this.position + "m");
		
		if(this.option != null) {
			
			switch(this.option) {
			
				case "add":
					System.out.println("subiu");
				break;
				
				case "rem":
					System.out.println("desceu");
				break;
			}
		}
		System.out.println("");
	}
}
