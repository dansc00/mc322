package com.unicamp.mc322.lab04.VacinaCovid;

import com.unicamp.mc322.lab04.Posicao.Posicao;

public class Posto {
	
	protected final int MAX_DIAS_ATENDIMENTO = 3;
	
	protected String nomePosto;
	protected Posicao enderecoPosto;
	protected int diasAtendimento[] = new int[MAX_DIAS_ATENDIMENTO];
	protected int maxAtendimento[] = new int[MAX_DIAS_ATENDIMENTO];
	
	public Posto() {
		
		this.nomePosto = null;
		this.enderecoPosto = null;
		
		for(int i = 0; i < MAX_DIAS_ATENDIMENTO; i++) {
			
			this.maxAtendimento[i] = 0;
			this.diasAtendimento[i] = 0;
		}
	}	
}
