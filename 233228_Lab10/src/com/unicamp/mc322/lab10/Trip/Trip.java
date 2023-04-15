package com.unicamp.mc322.lab10.Trip;

import java.util.ArrayList;
import com.unicamp.mc322.lab10.user.*;
import com.unicamp.mc322.lab10.vehicle.*;

public class Trip {

	private Passenger passengers[];
	private ArrayList<Stop> stops;
	private Driver driver;
	private Vehicle car;
	private double distance;
	private int nPassengers;
	private int nStops;
	
	private final int MAX_PASSENGERS = 4;
	
	public Trip(Driver driver, Vehicle car, double distance) {
		
		this.driver = driver;
		this.car = car;
		this.distance = distance;
		this.passengers = new Passenger[this.MAX_PASSENGERS];
		this.stops = new ArrayList();
		this.nPassengers = 0;
		this.nStops = 0;
	}
	
	public void addPassenger(Passenger p) {
		
		if(this.verifyCapacity()) {
			
			int pos = 0;
			for(Passenger x : this.passengers) {
				
				if(x == null) {
					this.passengers[pos] = p;
				}
				
				pos++;
			}
			
			this.nPassengers++;
		}
		else {
			
			System.out.println("O carro possui lotação máxima.");
		}
	}
	
	public void removePassenger(Passenger p) {
		
		int pos = 0;
		for(Passenger x : this.passengers) {
			
			if(x.equals(p)) {
				
				this.passengers[pos] = null;
			}
			
			pos++;
		}
		
		this.nPassengers--;
	}
	
	public void addStop(double position, Passenger p, String option) {
		
		if(option != null) {
			
			switch(option) {
				
				case "add":
					
					this.addPassenger(p);
				break;
				
				case "rem":
					
					this.removePassenger(p);
				break;
			}
		}
		
		stops.add(new Stop(p, position, option));
		this.nStops++;
	}
	
	public void endTrip() {
		
		this.tripSummary();
		System.out.println("Preço da viagem: R$"+ this.calcPrice());
		System.out.println("");
	}
	
	private double calcPrice() {
		
		double price = 0;
		switch(this.car.getCarType()) {
		
			case "Luxure":
				
				price = 7 + ((this.distance/100)*3.50) + (2.70 * this.nStops);
			break;
			
			case "Common":
				
				price = 3 + ((this.distance/100)*2) + (1.50 * this.nStops);
			break;
		}
		
		return price;
	}
	
	private void tripSummary() {
		
		System.out.println("RESUMO DA VIAGEM:");		
		System.out.println("Motorista: "+ this.driver.getName());
		System.out.println("Distância percorrida: "+ this.distance + "m");
		
		System.out.println("PARADAS:");
		for(Stop s : this.stops) {
			
			s.printDetails();
		}
	}
	
	private boolean verifyCapacity() {
		
		if(this.passengers.length > this.MAX_PASSENGERS) {
			return false;
		}
		
		return true;
	}
}
