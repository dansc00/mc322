package com.unicamp.mc322.project.game.skills;

import com.unicamp.mc322.project.game.Applicable;
import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.entities.Pokemon;

public class HugePower extends Skill implements Applicable{

	public HugePower(String name, int durationShifts){

		super(name, durationShifts);

		super.addUsableType(Type.FIRE);
		super.addUsableType(Type.WATER);
		super.addUsableType(Type.DRAGON);
		super.addUsableType(Type.ELECTRIC);
		super.addUsableType(Type.PSYCHIC);
		this.addUsableType(Type.GRASS);
	}

	public void getPassiveEffect(Pokemon x){
		
		this.removeShift();
		if(this.getDurationShifts() == 0){
			this.removeEffect(x);
		}
	}

	public void applyEffect(Pokemon x){
		
		x.setAtkPoints(x.getAtkPoints() * 2);
		x.setDefPoints(x.getDefPoints() * 2);
		x.setCurrentHP(x.getCurrentHP() - 5);
		this.setDurationShifts(3);
	}

	public void removeEffect(Pokemon x){

		x.setAtkPoints(x.getAtkPoints() / 2);
		x.setDefPoints(x.getDefPoints() / 2);
	}
}