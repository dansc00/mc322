package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;
import java.lang.Math;

public class Mansao extends Residencia {
	
	private double metQuad;
	
	public Mansao(String id, String nome, double metQuad, Posicao pos, double valAluguel) {
		
		super(id, nome, 0, 0, pos, valAluguel, "MANSAO");
		this.metQuad = metQuad;
	}
	
	public double getMetQuad() {
		return this.metQuad;
	}
	
	public void imprimeInformacaoMansao() {
		System.out.println(this.getMetQuad() + " metros quadrados");
	}
	
	@Override
	public double calcularAluguel(int dias, int nPessoas) {
		
		double dEfetiva, preco = 0;
		
		for(int i = 1; i <= dias; i++) {
			
			dEfetiva = this.getValAluguel() * Math.pow((100 * nPessoas)/this.getMetQuad(), i);
			preco += dEfetiva;
		}
		
		return preco;
	}
}
