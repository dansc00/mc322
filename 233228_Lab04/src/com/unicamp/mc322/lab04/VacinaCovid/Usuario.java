package com.unicamp.mc322.lab04.VacinaCovid;

import com.unicamp.mc322.lab04.Posicao.Posicao;

public class Usuario {
	
	protected String nomeUsuario;
	protected String cpf;
	protected int idade;
	protected Posicao enderecoUsuario;
	protected boolean possuiAgendamento;
	
	public Usuario() {
		
		this.nomeUsuario = null;
		this.cpf = null;
		this.enderecoUsuario = null;
		this.idade = 0;
		this.possuiAgendamento = false;
	}
}
