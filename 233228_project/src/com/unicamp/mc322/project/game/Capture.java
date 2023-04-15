package com.unicamp.mc322.project.game;

import com.unicamp.mc322.project.game.dices.RandomValues;
import com.unicamp.mc322.project.game.entities.Pokemon;
import com.unicamp.mc322.project.game.entities.Player;
import com.unicamp.mc322.project.game.Battle;
import com.unicamp.mc322.project.game.exceptions.*;
import java.lang.Math;

public class Capture{

	private boolean captureResult;
	public Capture(){

		this.captureResult = false;
	}

	protected void tryCapture(Player p, Pokemon pk){

		try{
			if(getCaptureDistance(p, pk) <= pk.getCaptureDistance()){

				if(this.startCapture(p, pk)){

					p.addPokemon(pk);
				}
				else{

					pk.addAttempt();
				}
			}
			else{

				throw new InsufficientCaptureDistanceException("A distância de captura é insuficiente.");
			}
		}
		catch(InsufficientCaptureDistanceException e){
			e.printRequiredCaptureDistance(pk);
			e.printCurrentDistance(this.getCaptureDistance(p, pk));
		}

		if(pk.getCaptureAttempts() >= 2){

			Battle b = new Battle();
			b.startBattle(p, pk);
		}
	}

	private boolean startCapture(Player p, Pokemon pk){

		RandomValues r = new RandomValues(2, 6);

		int flag = r.rollTheDice(r.getQtdFace(), r.getQtdDice());

		if(flag > pk.getCaptureDistance() + pk.getCaptureDifficulty()){
			return true;
		}
		
		return false;
	}

	private	double getCaptureDistance(Player p, Pokemon pk){

		double distance = Math.sqrt(Math.pow(((pk.getPos().getX()+1) - (p.getPos().getX()+1)),2) + Math.pow(((pk.getPos().getY()+1) - (p.getPos().getY()+1)), 2));

		return distance;
	}
}