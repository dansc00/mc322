package com.unicamp.mc322.project.game.skills;

import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.entities.Pokemon;

public class Berserk extends Skill{

	public Berserk(String name, int durationShifts){

		super(name, durationShifts);

		super.addUsableType(Type.ELECTRIC);
		super.addUsableType(Type.DRAGON);
	}

	public void getPassiveEffect(Pokemon x){

		if(x.getCurrentHP() < (x.getMaxHP() / 2)){
			
			if(this.getDurationShifts() > 0){

				this.removeShift();
				x.setAtkPoints(x.getAtkPoints() * 2);
			}
		}
		else{
			this.setDurationShifts(1);
			this.removeEffect(x);
		}
	}

	protected void removeEffect(Pokemon x){

		x.setAtkPoints(x.getAtkPoints()/2);
	}
}