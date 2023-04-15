package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public class Experiencia extends Elemento{
	
	private int maxParticipantes;
	private double precoBase, precoDesc;
	
	public Experiencia(String id, String nome, Posicao pos, double precoBase, double precoDesc, int maxParticipantes) {
		
		super(id, nome, pos, "EXPERIENCIA");
		this.maxParticipantes = maxParticipantes;
		this.precoBase = precoBase;
		this.precoDesc = precoDesc;
	}
	
	public int getMaxParticipantes() {
		return this.maxParticipantes;
	}
	
	public double getPrecoBase() {
		return this.precoBase;
	}
	
	public double getPrecoDesc() {
		return this.precoDesc;
	}
	
	public void imprimeInformacaoExperiencia() {
		System.out.println("Máximo de participantes: "+ this.getMaxParticipantes());
		System.out.println("Preço base: R$"+ this.getPrecoBase());
		System.out.println("Preço com desconto(para menores de idade): R$"+ this.getPrecoDesc());
	}
}
