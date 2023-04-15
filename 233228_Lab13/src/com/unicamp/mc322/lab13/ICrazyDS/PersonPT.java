package com.unicamp.mc322.lab13.ICrazyDS;

import com.unicamp.mc322.lab13.ICrazyDS.Date.BirthDate;

public class PersonPT {

	private String name, cpf;
	private int age;
	
	public PersonPT(BirthDate birthDate, String cpf, String name) {
		
		this.age = birthDate.getAge();
		this.cpf = cpf;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public int getAge() {
		return this.age;
	}
}
