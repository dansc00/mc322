package com.unicamp.mc322.lab13.ICrazyDS.Order;

import com.unicamp.mc322.lab13.ICrazyDS.PersonPT;

public abstract class Order implements IOrder {

	private PersonPT client;
	private int nShifts;
	private String id;
	private double priorityPoints;
		
	public Order(PersonPT client, String id) {
		
		this.client = client;
		this.id = id;
		this.nShifts = 0;
		this.priorityPoints = 0;
	}
	
	protected void addShift() {
		this.nShifts++;
	}
	
	public int getShifts() {
		return this.nShifts;
	}
	
	public String getId() {
		return this.id;
	}
	
	public double getPriorityPoints() {
		return this.priorityPoints;
	}
	
	public void setPriorityPoints(double points) {
		
		this.priorityPoints = points;
	}
	
	public abstract int getCustomPriority();
	
	public String getPartClientInformation() {
		return this.client.getName();
	}
	
	public void getTotalClientInformation() {
		
		System.out.println("Nome do Cliente: "+ this.client.getName());
		System.out.println("CPF do Cliente: "+ this.client.getCpf());
		System.out.println("Idade do Cliente: "+ this.client.getAge());
	}
	
	public PersonPT getClient() {
		return this.client;
	}



}
