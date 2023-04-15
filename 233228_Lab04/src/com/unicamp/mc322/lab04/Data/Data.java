package com.unicamp.mc322.lab04.Data;

import java.util.GregorianCalendar;

import com.unicamp.mc322.lab04.VacinaCovid.Posto;

public class Data {
	
	private GregorianCalendar gc = new GregorianCalendar();
	
	// guarda ano, mes e dia atual
	private final int ANO_ATUAL = gc.get(gc.YEAR); 
	private final int MES_ATUAL = gc.get(gc.MONTH) + 1;  
	private final int DIA_ATUAL = gc.get(gc.DAY_OF_MONTH);
	
	// guarda dia da semana (1 = domingo, 2 = segunda...)
	private final int DIA_SEMANA_ATUAL = gc.get(gc.DAY_OF_WEEK);
	
	// guarda dia, mes e ano de nascimento
	private int diaNasc, mesNasc, anoNasc;
	
	public Data(int ano, int mes, int dia) {
		
		this.diaNasc = dia;
		this.mesNasc = mes;
		this.anoNasc = ano;
	}
	
	public int getDiaNasc() {
		return this.diaNasc;
	}
	
	public int getMesNasc() {
		return this.mesNasc;
	}
	
	public int getAnoNasc() {
		return this.anoNasc;
	}
	
	public int getAnoAtual() {
		return this.ANO_ATUAL;
	}
	
	public int getMesAtual() {
		return this.MES_ATUAL;
	}
	
	public int getDiaSemanaAtual() {
		return this.DIA_SEMANA_ATUAL;
	}
	
	public int calcularIdade(int diaNasc, int mesNasc, int anoNasc) {
		
		int idade = ANO_ATUAL - anoNasc;
		
		if(MES_ATUAL < mesNasc) {
			idade--;
		}
		else if(MES_ATUAL == mesNasc) {
			
			if(DIA_ATUAL < diaNasc) {
				idade--;
			}
		}
		
		return idade;
	}
}
