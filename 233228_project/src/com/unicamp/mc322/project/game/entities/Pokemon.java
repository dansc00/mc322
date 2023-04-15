package com.unicamp.mc322.project.game.entities;

import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.skills.*;
import java.util.LinkedList;

public class Pokemon extends Entity{

	private String name;
	private int atkPoints, defPoints, currentHP, maxHP;
	private Type types[];
	private int captureAttempts;
	private LinkedList<Skill> passiveSkills;
	private LinkedList<Skill> activeSkills;
	private int captureDistance;
	private int captureDifficulty;

	public Pokemon(String name, int atkP, int defP, int currentHP, int maxHP, Type t1, Type t2, Position pos){

		super(pos);
		this.name = name;
		this.atkPoints = atkP;
		this.defPoints = defP;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.captureAttempts = 0;
		this.passiveSkills = new LinkedList<Skill>();
		this.activeSkills = new LinkedList<Skill>();
		this.captureDistance = 0;
		this.captureDifficulty = 0;

		this.types = new Type[2];
		this.types[0] = t1;
		this.types[1] = t2;
	}

	// getters / setters
	public int getAtkPoints(){
		return this.atkPoints;
	}

	public void setAtkPoints(int atkP){
		this.atkPoints = atkP;
	}

	public int getDefPoints(){
		return this.defPoints;
	}

	public void setDefPoints(int defP){
		this.defPoints = defP;
	}

	public int getCurrentHP(){
		return this.currentHP;
	}

	public void setCurrentHP(int currentHP){
		this.currentHP = currentHP;
	}

	public int getMaxHP(){
		return this.maxHP;
	}

	public String getName(){
		return this.name;
	}

	public int getCaptureAttempts(){
		return this.captureAttempts;
	}

	public int getCaptureDistance(){
		return this.captureDistance;
	}

	public void setCaptureDistance(int captureDistance){
		this.captureDistance = captureDistance;
	}

	public int getCaptureDifficulty(){
		return this.captureDifficulty;
	}

	public void setCaptureDifficulty(int captureDifficulty){
		this.captureDifficulty = captureDifficulty;
	}
	// fim dos getters / setters

	public void checkFainting(){

		if(this.getCurrentHP() <= 0){
			System.out.println(this.getName() + "desmaiou.");
		}
	}

	public void addAttempt(){
		this.captureAttempts++;
	}

	@Override
	public String toString(){
		return "PK";
	}
}