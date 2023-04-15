package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public class Apartamento extends Residencia {
	
	private int andar;
	private boolean temSacada;
	
	public Apartamento(String id, String nome, int numQuartos, int numBanheiros, int andar, boolean temSacada, Posicao pos, double valAluguel) {
		
		super(id, nome, numQuartos, numBanheiros, pos, valAluguel, "APARTAMENTO");
		this.andar = andar;
		this.temSacada = temSacada;
	}
	
	public int getAndar() {
		return this.andar;
	}
	
	public boolean getTemSacada() {
		return this.temSacada;
	}
	
	public void imprimeInformacaoApartamento() {
		
		System.out.println("Andar: "+ this.getAndar());
		System.out.println("Sacada: "+ this.getTemSacada());
	}
	
	@Override
	public double calcularAluguel(int dias, int nPessoas) {
		
		double preco = 0;
		
		preco = this.getValAluguel() + ((this.getValAluguel() * this.getAndar())/ 100);
		
		if(this.getTemSacada()) {
			preco += this.getValAluguel();
		}
		
		return preco*dias;
	}
}
