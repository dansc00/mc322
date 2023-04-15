package com.unicamp.mc322.project.game.entities.items;

import com.unicamp.mc322.project.game.entities.*;
import com.unicamp.mc322.project.game.position.Position;

public abstract class Item extends Entity{

	private String name;

	public Item(Position pos, String name){

		super(pos);
		this.name = name;
	}	

	public String getName(){
		return this.name;
	}

	@Override
	public String toString(){
		return "I";
	}
}