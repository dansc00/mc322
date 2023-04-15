package com.unicamp.mc322.lab04.Posicao;

import java.lang.Math;

public class Posicao {
	
	private int coordX; // coordenada x do ponto
	private int coordY; // coordenada y do ponto
	
	public Posicao(int x, int y) {
		
		this.coordX = x;
		this.coordY = y;
	}
	
	public int getCoordX() {
		return this.coordX;
	}
	
	public int getCoordY() {
		return this.coordY;
	}
	
	// calcula distância entre dois pontos
	public double calculaDistancia(int x1, int x2, int y1, int y2) {
		
		double dist;
		dist = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
		
		return dist;
	}
}
