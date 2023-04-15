package com.unicamp.mc322.lab10.user;

public class User {

	private String name;
	private String cpf;
	private String birthDate;
	private String credCardNum;
	private String userType;
	
	public User(String name, String cpf, String birthDate, String userType, String credCardNum) {
		
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.credCardNum = credCardNum;
		this.userType = userType;
		
	}
	
	public void printDetails() {
		
		System.out.println("Nome: "+this.name);
		System.out.println("CPF: "+this.cpf);
		System.out.println("Data de Nascimento: "+this.birthDate);
		System.out.println("Cartão de crédito: "+this.credCardNum);
		System.out.println("Usuário: "+this.userType);
	}
	
	public String getUserType() {
		return this.userType;
	}
	
	public String getName() {
		return this.name;
	}
}
