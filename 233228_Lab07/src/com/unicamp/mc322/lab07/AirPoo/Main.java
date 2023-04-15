package com.unicamp.mc322.lab07.AirPoo;

import com.unicamp.mc322.lab07.AirPoo.Cadastro.*;
import com.unicamp.mc322.lab07.AirPoo.Posicao.Posicao;

public class Main {
	
	private Elemento listaCadastro[];
	private Reserva listaReservas[];
	private int nElementos;
	private int nReservas;
	
	public Main(int cadastros, int reservas) {
		
		this.listaReservas = new Reserva[reservas];
		this.listaCadastro = new Elemento[cadastros];
		this.nElementos = 0;
		this.nReservas = 0;
	}
	
	protected void cadastrarApartamento(String id, String nome, int numQuartos, int numBanheiros, int andar, boolean temSacada, Posicao pos, double valAluguel) {
		
		if(this.verificaIgualdadeId(id)) {
			System.out.println("O ID passado já existe no sistema. Não foi possivel realizar o cadastro.");
		}
		else {
			Apartamento ap = new Apartamento(id, nome, numQuartos, numBanheiros, andar, temSacada, pos, valAluguel);
			this.listaCadastro[this.nElementos] = ap;
			this.nElementos++;
		}
		
	}
	
	protected void cadastrarCasa(String id, String nome, int numQuartos, int numBanheiros, boolean possuiPiscina, Posicao pos, double valAluguel) {
		
		if(this.verificaIgualdadeId(id)) {
			System.out.println("O ID passado já existe no sistema. Não foi possivel realizar o cadastro.");
		}
		else {
			Casa ca = new Casa(id, nome, numQuartos, numBanheiros, possuiPiscina, pos, valAluguel);
			this.listaCadastro[this.nElementos] = ca;
			this.nElementos++;

		}
		
	}
	
	protected void cadastrarMansao(String id, String nome, double metQuad, Posicao pos, double valAluguel) {
	
		if(this.verificaIgualdadeId(id)) {
			System.out.println("O ID passado já existe no sistema. Não foi possivel realizar o cadastro.");
		}
		else {
			Mansao ma = new Mansao(id, nome, metQuad, pos, valAluguel);
			this.listaCadastro[this.nElementos] = ma;
			this.nElementos++;

		}
		
	}
	
	protected void cadastrarRede(String id, String nome, Posicao pos, double precoRede) {
	
		if(this.verificaIgualdadeId(id)) {
			System.out.println("O ID passado já existe no sistema. Não foi possivel realizar o cadastro.");
		}
		else {
			Rede re = new Rede(id, nome, pos, precoRede);
			this.listaCadastro[this.nElementos] = re;
			this.nElementos++;

		}
		
	}
	
	protected void cadastrarExperiencia(String id, String nome, Posicao pos, double precoBase, double precoDesc, int maxParticipantes) {
		
		if(this.verificaIgualdadeId(id)) {
			System.out.println("O ID passado já existe no sistema. Não foi possivel realizar o cadastro.");
		}
		else {
			Experiencia exp = new Experiencia(id, nome, pos, precoBase, precoDesc, maxParticipantes);
			this.listaCadastro[this.nElementos] = exp;
			this.nElementos++;

		}
		
	}
	
	protected void cadastrarPontoTur(String nome, Posicao pos) {
		
		PontoTur tur = new PontoTur(nome, pos);
		this.listaCadastro[this.nElementos] = tur;
		this.nElementos++;
	}
	
	protected void removerElemento(String id) {
		
		int posRem = 0;
		for(int i = 0; i < this.nElementos; i++) {
			
			if(this.listaCadastro[i].getId().equals(id)) {
				this.listaCadastro[i] = null;
				posRem = i;
				break;
			}
		}
		
		for(int j = posRem; j < this.nElementos-1; j++) {
			
			this.listaCadastro[j] = this.listaCadastro[j+1];
		}
		
		this.nElementos--;
	}
	
	protected void imprimirElementos() {
		
		for(int i = 0; i < this.nElementos; i++) {
			
			System.out.println("CADASTRO "+ (i+1));
			
			switch(this.listaCadastro[i].getTipo()){
			
			case "APARTAMENTO":
				Apartamento ap = (Apartamento)this.listaCadastro[i];
				ap.imprimeInformacaoBasica();
				ap.imprimeInformacaoResidencia();
				ap.imprimeInformacaoApartamento();
			break;
			
			case "CASA":
				Casa ca = (Casa)this.listaCadastro[i];
				ca.imprimeInformacaoBasica();
				ca.imprimeInformacaoResidencia();
				ca.imprimeInformacaoCasa();
			break;
			
			case "MANSAO":
				Mansao ma = (Mansao)this.listaCadastro[i];
				ma.imprimeInformacaoBasica();
				ma.imprimeInformacaoResidencia();
				ma.imprimeInformacaoMansao();
			break;
			
			case "REDE":
				Rede re = (Rede)this.listaCadastro[i];
				re.imprimeInformacaoBasica();
				re.imprimeInformacaoRede();
			break;
			
			case "EXPERIENCIA":
				Experiencia exp = (Experiencia)this.listaCadastro[i];
				exp.imprimeInformacaoBasica();
				exp.imprimeInformacaoExperiencia();
			break;
			
			case "PONTOTUR":
				PontoTur pt = (PontoTur)this.listaCadastro[i];
				pt.imprimeInformacaoBasica();
			break;
			}
			System.out.println("");
		}
	}
	
	protected void criarReserva(String id, int nPessoas, int nMenores, int dias) {
		
		Reserva r = new Reserva(id, nPessoas, nMenores, dias);
		this.listaReservas[this.nReservas] = r;
		this.nReservas++;
	}
	
	private boolean verificaIgualdadeId(String id) {
		
		for(int i = 0; i < this.nElementos; i++) {
			
			if(id.equals(this.listaCadastro[i].getId())) {
				return true;
			}
		}
		
		return false;
	}
}
