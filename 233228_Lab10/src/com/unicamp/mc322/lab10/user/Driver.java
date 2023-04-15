package com.unicamp.mc322.lab10.user;

import com.unicamp.mc322.lab10.vehicle.Vehicle;

public class Driver extends User {

	private String driverLicenceNum;
	private Vehicle vehicles[];
	private int nVehicles;
	
	public Driver(String name, String cpf, String birthDate, String userType, String credCardNum, String driverLicenceNum, int maxVehicles) {
		
		super(name, cpf, birthDate, userType, credCardNum);
		this.driverLicenceNum = driverLicenceNum;
		this.vehicles = new Vehicle[maxVehicles];
		this.nVehicles = 0;
	}
	
	public void addCar(int manufactureYear, String licencePlate, String carType) {
		
		this.vehicles[this.nVehicles] = new Vehicle(manufactureYear, licencePlate, carType, this);
		this.nVehicles++;
	}
	
	@Override
	public void printDetails() {
		
		super.printDetails();
		System.out.println("Carteira de motorista: "+this.driverLicenceNum);
		System.out.println("Nº de veículos: "+this.nVehicles);
		System.out.println("");
		System.out.println("INFORMAÇÕES DO(S) VÉICULO(S):");
		
		for(Vehicle v : this.vehicles) {
			
			v.printDetails();
			System.out.println("");
		}

	}
	
	public Vehicle getVehicle(String licencePlate) {
		
		for(Vehicle v : this.vehicles) {
			
			if(v.getLicencePlate().equals(licencePlate)) {
				return v;
			}
		}
		
		return null;
	}
}
