package com.unicamp.mc322.project.game;

import com.unicamp.mc322.project.game.entities.Pokemon;
import com.unicamp.mc322.project.game.entities.Player;
import com.unicamp.mc322.project.game.exceptions.*;
import java.util.Scanner;

public class Battle{

	private Pokemon currentPokemon; // marca pokemon atacante no turno
	private int option; // marca opção de ataque
	private boolean checkEndShift; // verifica final de turno

	public Battle(){

		this.currentPokemon = null;
		this.option = 0;
		this.checkEndShift = false;
	}

	protected void startBattle(Player p, Pokemon p2){
		
		Scanner r = new Scanner(System.in);

		System.out.println("SELECIONE UM POKEMON PARA O COMBATE:");
		p.listPokemons();
		int i = r.nextInt();
		Pokemon p1 = p.selectPokemon(i);

		while(true){	
			
			// verifica fim de combate
			if(p1.getCurrentHP() <= 0){
				System.out.println("Fim de combate. " + p2.getName() + "é o vencedor. ");
				p1.checkFainting();
				break;
			}

			if(p2.getCurrentHP() <= 0){
				System.out.println("Fim de combate. " + p1.getName() + "é o vencedor. ");
				p2.checkFainting();
				break;
			}

			// altera turnos de ataque e defesa
			if(this.currentPokemon == null){
				this.currentPokemon = p1;
			}
			else if(this.currentPokemon == p1){
				this.currentPokemon = p2;
			}
			else{
				this.currentPokemon = p1;
			}

			// verifica opções de ataque
			do{
				this.printOptions();
				this.option = r.nextInt();

				switch(this.option){

					case 1:
						this.useBasicAttack(p1, p2);
						this.checkEndShift = true;
					break;

					case 2:
						this.useSkill(p1, p2);
						this.checkEndShift = true;
					break;

					default:
						throw new InvalidInputOptionException("Opção inválida. Tente novamente.");
						this.checkEndShift = false;
					break;
				}
			} while(!this.checkEndShift);
		}
	}

	private void printOptions(){

		System.out.println();
		System.out.println("OPÇÕES DE COMBATE:");
		System.out.println("1 PARA UTILIZAR UM ATAQUE BASE");
		System.out.println("2 PARA UTILIZAR UMA HABILIDADE");
		System.out.println();
	}

	private void useSkill(Pokemon p1, Pokemon p2){


	}

	private void useBasicAttack(Pokemon p1, Pokemon p2){

		int damage = 0;
		if(this.currentPokemon.equals(p1)){

			damage = p1.getAtkPoints() - p2.getDefPoints();
			if(damage == 0){
				damage = 1;
			}

			p2.setCurrentHP(p2.getCurrentHP() - damage);
		}
		else{

			damage = p2.getAtkPoints() - p1.getDefPoints();
			if(damage == 0){
				damage = 1;
			}

			p1.setCurrentHP(p1.getCurrentHP() - damage);
		}
	}
}