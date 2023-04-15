package com.unicamp.mc322.project.game.skills;

import java.util.LinkedList;
import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.entities.Pokemon;

public abstract class Skill{

	private String name;
	private int durationShifts; // turnos de duração
	private LinkedList<Type> usableTypes; // tipos compativeis
	private LinkedList<Type> unusableTypes; // tipos incompativeis

	public Skill(String name, int durationShifts){

		this.name = name;
		this.usableTypes = new LinkedList<Type>();
		this.unusableTypes = new LinkedList<Type>();
		this.durationShifts = durationShifts;
	}

	public abstract void getPassiveEffect(Pokemon x);
	protected abstract void removeEffect(Pokemon x);

	public void addUsableType(Type t){
		this.usableTypes.add(t);
	}

	public void addUnusableType(Type t){
		this.unusableTypes.add(t);
	}

	public int getDurationShifts(){
		return this.durationShifts;
	}

	public void setDurationShifts(int shifts){
		this.durationShifts = shifts;
	}

	public void removeShift(){
		this.durationShifts--;
	}

	public String getName(){
		return this.name;
	}
}