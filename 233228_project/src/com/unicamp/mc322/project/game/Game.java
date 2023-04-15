package com.unicamp.mc322.project.game;

import com.unicamp.mc322.project.game.*;
import com.unicamp.mc322.project.game.dices.*;
import com.unicamp.mc322.project.game.entities.*;
import com.unicamp.mc322.project.game.map.*;
import com.unicamp.mc322.project.game.position.*;
import com.unicamp.mc322.project.game.skills.*;
import java.util.Scanner;

public class Game {

 	private boolean exitSelected;

	public Game(){
    
		this.exitSelected = false;
	}

	protected void startGame(){

		Scanner sc = new Scanner(System.in);

		System.out.println("Jogo iniciado!");
		System.out.println("Bem vindo ao jogo de pokemon desenhado pela equipe Rocket!");
		System.out.println();

		System.out.println("Qual o seu nome?");
		String name = sc.nextLine();
		System.out.println();
		
		Player p1 = createPlayer(name);

		World world = new World();
		world.createBasicWorld(p1);		

		System.out.println("Você deve jogar 2 dados de 6 lados para definir a quantidade de movimentos no turno");
		System.out.println();

		System.out.println("Utilize as teclas para movimentação: ");
		System.out.println("W = cima");
		System.out.println("S = baixo");
		System.out.println("A = esquerda");
		System.out.println("D = direita");
		System.out.println();

		String movOption = "";
		Island currentIsland = world.getIslands().get(0);
		p1.setCurrentIsland(currentIsland);
		while(!this.exitSelected){

			System.out.println("Lançando dados...");
			int movimentosIniciais = movement();
			
			System.out.println("Você tem " + movimentosIniciais + " casas para andar");
			System.out.println();

			for(int i = 0; i < movimentosIniciais; i++){
				movOption = sc.nextLine();		

				currentIsland.printMap();
				updateBoard(p1, movOption, currentIsland);
			}	
		}
	}

	private Player createPlayer(String name){
		Player p = new Player(name, new Position(0, 0));
		return p;
	}

	private int movement(){
		RandomValues r = new RandomValues();
		int movimentos = r.rollTheDice(2, 6);
		return movimentos;
	}

	private void updateBoard(Player p, String movOption, Island currentIsland){
		
		Position newPosition = null;
		switch(movOption){

			case "W":

				newPosition = new Position(p.getPos().getX()-1, p.getPos().getY());
				currentIsland.addEntity(p, newPosition);		
			break;

			case "S":

				newPosition = new Position(p.getPos().getX()+1, p.getPos().getY());
				currentIsland.addEntity(p, newPosition);	
			break;

			case "A":

				newPosition = new Position(p.getPos().getX(), p.getPos().getY()-1);
				currentIsland.addEntity(p, newPosition);	
			break;

			case "D":

				newPosition = new Position(p.getPos().getX(), p.getPos().getY()+1);
				currentIsland.addEntity(p, newPosition);	
			break;
		}

		currentIsland.removeEntity(p.getPos());
		p.setPos(newPosition);
	}
	
}