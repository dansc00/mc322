package com.unicamp.mc322.project.game.entities.items;

import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.Applicable;
import com.unicamp.mc322.project.game.entities.*;

public class Fruit extends Item implements Applicable{

	public Fruit(Position pos, String name){

		super(pos, name);
	}

	// aplica efeito do item
	public void applyEffect(Pokemon x){
		
		try{

			// restaura hp atual para hp total
			x.setCurrentHP(x.getMaxHP());
				
		}
		catch(IndexOutOfBoundsException exception){

			System.out.println("O pokemon referido não existe.");
		}
	}

	@Override
	public String toString(){
		return super.toString();
	}
}