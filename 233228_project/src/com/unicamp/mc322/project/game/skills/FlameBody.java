package com.unicamp.mc322.project.game.skills;

import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.dices.RandomValues;
import com.unicamp.mc322.project.game.entities.Pokemon;

public class FlameBody extends Skill{

	public FlameBody(String name, int durationShifts){
		
		super(name, durationShifts);
		super.addUsableType(Type.FIRE);
		super.addUsableType(Type.DRAGON);

		super.addUnusableType(Type.WATER);
		super.addUnusableType(Type.FIRE);
	}

	public void getPassiveEffect(Pokemon x){

    	RandomValues r = new RandomValues(3, 1);
		int probability = r.rollTheDice(r.getQtdFace(), r.getQtdDice());

    	if(probability == 1){
			

    	}
    
		
	}	
}