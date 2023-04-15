package com.unicamp.mc322.project.game.dices;
import java.util.Random;

public class RandomValues {
	private int qtdFace;
	private int qtdDice;
	private int numero;

	public RandomValues(int qtdFace, int qtdDice) {
		this.qtdFace = qtdFace;
		this.qtdDice = qtdDice;
    rollTheDice(qtdFace, qtdDice);
	}

  public RandomValues() {
    this.qtdFace = 0;
		this.qtdDice = 0;
	}

	public int getQtdFace() {
		return qtdFace;
	}

	public void setQtdFace(int qtdFace) {
		this.qtdFace = qtdFace;
	}

	public int getQtdDice() {
		return qtdDice;
	}

	public void setQtdDice(int qtdDice) {
		this.qtdDice = qtdDice;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int rollTheDice(int qtdFace, int qtdDice){
    	Random gerador = new Random();
    	for(int i = 0; i < qtdDice; i++){
		  int resultado = gerador.nextInt(qtdFace);
		  numero += resultado;
	  	}
    	return numero;
  	}
}
