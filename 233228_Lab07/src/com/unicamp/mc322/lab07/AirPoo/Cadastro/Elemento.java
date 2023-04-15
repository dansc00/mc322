package com.unicamp.mc322.lab07.AirPoo.Cadastro;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public abstract class Elemento {

	private String id;
	private String nome;
	private Posicao pos;
	private final String TIPO;
	
	public Elemento(String id, String nome, Posicao pos, String tipo) {
		
		this.id = id;
		this.nome = nome;
		this.pos = pos;
		this.TIPO = tipo;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTipo() {
		return this.TIPO;
	}
	
	public void imprimeInformacaoBasica() {
		System.out.println(this.getTipo());
		System.out.println(this.getId());
		System.out.println(this.getNome());
	}
	
	
}
