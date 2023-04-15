package com.unicamp.mc322.lab07.AirPoo;

import com.unicamp.mc322.lab07.AirPoo.Posicao.*;

public abstract class AirPoo {
	
	private static Main app;
	
	public static void main(String args[]) {
		
		app = new Main(10);
		
		app.cadastrarPontoTur("Parque Ibirapuera", new Posicao(20, -30));
		app.cadastrarPontoTur("Catedral Metropolitana", new Posicao(5, 40));

		app.cadastrarApartamento("AP14", "Taquaral Flat 14", 3, 2, 1, true, new Posicao(10,10), 150);
		app.cadastrarApartamento("AP99", "Hotel Nacional", 2, 2, 9, false, new Posicao(-15,7), 180);
		
		app.cadastrarCasa("DECOURT01", "Pousada do Jorge", 5, 4, true, new Posicao(37,81), 450);
		
		app.cadastrarMansao("GASTEI01RIM", "Mansão Deluxe", 1200, new Posicao(-10, -10), 2000);
		
		app.cadastrarRede("RED1", "Rede Simples", new Posicao(1,1), 20);
		
		app.cadastrarExperiencia("RODIZIOPIZZA", "Rodizio de pizza", new Posicao(5,6), 59, 39, 10);
		
		app.cadastrarApartamento("AP14", "Taquaral Flat 14", 3, 2, 1, true, new Posicao(10,10), 150);
		
		app.removerElemento("RED1");

		app.imprimirElementos();
	}
}
