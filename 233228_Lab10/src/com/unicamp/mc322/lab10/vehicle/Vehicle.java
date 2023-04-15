package com.unicamp.mc322.lab10.vehicle;

import com.unicamp.mc322.lab10.user.Driver;

public class Vehicle {
	
	private String licencePlate;
	private int manufactureYear;
	private Driver owner;
	private String carType;
	
	public Vehicle(int manufactureYear, String licencePlate, String carType, Driver owner) {
		
		this.manufactureYear = manufactureYear;
		this.licencePlate = licencePlate;
		this.carType = carType;
		this.owner = owner;
	}
	
	public String getCarType() {
		return this.carType;
	}
	
	public String getLicencePlate() {
		return this.licencePlate;
	}
	
	public void printDetails() {
		
		System.out.println("Placa: "+this.licencePlate);
		System.out.println("Ano de Fabricação: "+this.manufactureYear);
		System.out.println("Tipo de carro: "+this.carType);
	}
}
