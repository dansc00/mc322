package com.unicamp.mc322.project.game.entities.map_objects;

import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.map.Island;
import com.unicamp.mc322.project.game.entities.*;

public class Portal extends Entity{

  	private Position posIslandA;
  	private Position posIslandB;
  	private Island islandA;
  	private Island islandB;

  	public Portal(Position posIslandA, Island islandA, Island islandB, Position posIslandB){
    	super(posIslandA);
      this.islandA = islandA;
      this.islandB = islandB;
      this.posIslandB = posIslandB;
  	}

    public Position getPosA(){
      return this.posIslandA;
    }

    public Position getPosB(){
      return this.posIslandB;
    }

    public Island getIslandA(){
      return this.islandA;
    }

     public Island getIslandB(){
      return this.islandB;
    }

    public boolean canUsePortal(Portal portal){
      if (portal.getIslandA().isVisited() && portal.getIslandA().isVisited()){
        return true;
      }
      else{
        return false;
      }
    }
	
	@Override
	public String toString(){
		return "PO";
	}
}