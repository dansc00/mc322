package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.user.*;
import com.unicamp.mc322.lab10.Trip.*;

public class App {

	private User users[];
	
	public static void main(String[] args) {
		
		App app = new App(3);
		
		Passenger u1 = new Passenger("Marcos", "145678798", "15/07/1998", "Passenger", "369874");
		Driver u2 = new Driver("Maria", "248679108", "12/02/1997", "Driver", "483530", "987654", 2);
		Passenger u3 = new Passenger("João", "654973652", "03/01/2002", "Passenger", "785632");
		
		u2.addCar(2009, "ABC-1234", "Luxure");
		u2.addCar(2013, "OOP-2020", "Common");
		
		app.users[0] = u1;
		app.users[1] = u2;
		app.users[2] = u3;
		
		app.printDetails();
		
		Trip t1 = new Trip(u2, u2.getVehicle("ABC-1234"), 500);
		t1.addPassenger(u1);
		t1.addStop(100, null, null);
		t1.addStop(500, u1, "rem");
		t1.endTrip();
		
		Trip t2 = new Trip(u2, u2.getVehicle("OOP-2020"), 2000);
		t2.addPassenger(u1);
		t2.addPassenger(u3);
		t2.addStop(100, null, null);
		t2.addStop(200, null, null);
		t2.addStop(300, u3, "rem");
		t2.addStop(700, null, null);
		t2.addStop(2000, u1, "rem");
		t2.endTrip();
		
		Trip t3 = new Trip(u2, u2.getVehicle("ABC-1234"), 700);
		t3.addPassenger(u3);
		t3.addStop(200, null, null);
		t3.addStop(500, null, null);
		t3.addStop(700, u3, "rem");
		t3.endTrip();
	}
	
	public App(int maxUsers) {
		
		this.users = new User[maxUsers];
	}
	
	private void printDetails() {
		
		System.out.println("INFORMAÇÕES DE USUÁRIOS CADASTRADOS");
		for(User u : this.users) {
			
			u.printDetails();
			System.out.println("-------------------------------------");
		
		}
	}
}
