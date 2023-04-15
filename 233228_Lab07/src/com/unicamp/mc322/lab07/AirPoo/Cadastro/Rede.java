package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public class Rede extends Elemento{
	
	private double precoRede;
	
	public Rede(String id, String nome, Posicao pos, double precoRede) {
		
		super(id, nome, pos, "REDE");
		this.precoRede = precoRede;
	}
	
	public double getPrecoRede() {
		return this.precoRede;
	}
	
	public void imprimeInformacaoRede() {
		System.out.println("Preço da rede: "+ this.getPrecoRede());
	}
}
