package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public abstract class Residencia extends Elemento {
	
	private int numQuartos;
	private int numBanheiros;
	private double valAluguel;
	
	public Residencia(String id, String nome, int numQuartos, int numBanheiros, Posicao pos, double valAluguel, String tipo) {
		
		super(id, nome, pos, tipo);
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.valAluguel = valAluguel;
	}
	
	public int getNumQuartos() {
		return this.numQuartos;
	}
	
	public int getNumBanheiros(){
		return this.numBanheiros;
	}
	
	public double getValAluguel() {
		return this.valAluguel;
	}
	
	public void imprimeInformacaoResidencia(){
		System.out.println(this.getNumBanheiros() + " banheiros");
		System.out.println(this.getNumQuartos() + " quartos");
		System.out.println("Valor diária: R$"+ this.getValAluguel());
	}
	
	public abstract double calcularAluguel(int dias, int nPessoas); 
		
	
	
}
