package com.unicamp.mc322.project.game.entities;

import com.unicamp.mc322.project.game.position.Position;

public abstract class Entity{

	private Position pos; // posição no mapa

	public Entity(Position pos){

		this.pos = pos;
	}

	public Position getPos(){
		return this.pos;
	}

	public void setPos(Position pos){
		this.pos = pos;
	}
}