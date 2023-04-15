package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public class Casa extends Residencia {
	
	private boolean possuiPiscina;
	
	public Casa(String id, String nome, int numQuartos, int numBanheiros, boolean possuiPiscina, Posicao pos, double valAluguel) {
		
		super(id, nome, numQuartos, numBanheiros, pos, valAluguel, "CASA");
		this.possuiPiscina = possuiPiscina;
	}
	
	public boolean getPossuiPiscina() {
		return this.possuiPiscina;
	}
	
	public void imprimeInformacaoCasa() {
		
		System.out.println("Possui piscina: " + this.getPossuiPiscina());
	}
	
	@Override
	public double calcularAluguel(int dias, int nPessoas) {
		
		double dEfetiva, incremento = 0;
		
		dEfetiva = (this.getNumBanheiros()/this.getNumQuartos()) * this.getValAluguel();
		
		if(this.getPossuiPiscina()) {
			
			for(int i = 0; i < dias; i++) {
				
				if(i >= 7) {
					break;
				}
				incremento += dEfetiva;
			}
		}
		
		return (dEfetiva*dias) + incremento;
	}
}
