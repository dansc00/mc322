package com.unicamp.mc322.lab07.AirPoo

import com.unicamp.mc322.lab07.AirPoo.Cadastro.*;

public class Reserva {
	
	private String id;
	private int nPessoas;
	private int nMenores;
	private int dias;
	
	public Reserva(String id, int nPessoas, int nMenores, int dias) {
		
		this.id = id;
		this.dias = dias;
		this.nMenores = nMenores;
		this.nPessoas = nPessoas;
		
		if(this.dias == 0) {
			this.dias = 1;
		}
	}
	
	protected double calcularTotal(Reserva listaReservas[], Elemento listaElementos[]) {
		
		double total = 0;
		
		for(Reserva re : listaReservas) {
			for(Elemento el : listaElementos) {
				
				if(el.getId().equals(re.id)) {
					
					switch(el.getTipo()){
						
						case "APARTAMENTO":
							Apartamento ap = (Apartamento)el;
							total += ap.calcularAluguel(re.dias, re.nPessoas);
						break;
						
						case "CASA":
							Casa ca = (Casa)ca;
							total += ca.calcularAluguel(re.dias, re.nPessoas);
						break;
						
						case "MANSAO":
							Mansao ma = (Mansao)ma;
							total += ma.calcularAluguel(re.dias, re.nPessoas);
						break;
						
						case "REDE":
						break;
						
						case "EXPERIENCIA":
						break;
					}
				}
			}
		}
	}
	
	
}

