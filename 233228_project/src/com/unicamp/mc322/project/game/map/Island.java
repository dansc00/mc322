package com.unicamp.mc322.project.game.map;

import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.entities.Entity;
import com.unicamp.mc322.project.game.dices.RandomValues;
import com.unicamp.mc322.project.game.dices.*;
import java.util.LinkedList;


public class Island{

	private Entity[][] island_map;
	private int lines;
	private int columns;
	private Type type1;
  private Type type2;
	private boolean alreadyVisited;
  private LinkedList<Entity> pokemonItemList;

	
  public Island(int lines, int columns, Type type1, Type type2){
		this.island_map = new Entity[lines][columns];
		this.lines = lines;
		this.columns = columns;
		this.type1 = type1;
    this.type2 = type2;
    this.pokemonItemList = new LinkedList<Entity>(); 
	}

	public Island(int lines, int columns, Type type){
		this.island_map = new Entity[lines][columns];
		this.lines = lines;
		this.columns = columns;
		this.type1 = type; 
	}

	public int getLines(){
		return this.lines;
	}

	public int getColumns(){
		return this.columns;
	}

	public Type getType1(){
		return this.type1;
	}

  public Type getType2(){
		return this.type2;
	}

  public boolean isSameType(Type type){
    if (type == this.getType1() || type == this.getType2()){
      return true;
    }
    else{
      return false;
    }
  }

	public boolean isVisited(){
		return this.alreadyVisited;
	}

	public void markAsVisited(){
		this.alreadyVisited = true;
	}

	public void addEntity(Entity entity, Position position){
		try{
			this.island_map[position.getX()][position.getY()] = entity;
		}
		catch(ArrayIndexOutOfBoundsException exception){
			System.out.println("Posição não válida");
		}
	}


	public void removeEntity(Position position){
			this.island_map[position.getX()][position.getY()] = null;
	}

/*
  public boolean isEdge(Position position){
    //verifica se posicação é borda do mapa (para colocar pontes)
    if (position.getX() == 0 || position.getX() == this.getLines() - 1){
      return true;
    }
    if (position.getY() == 0 || position.getY() == this.getColumns() - 1){
      return true;
    }
    else{
      return false;
    } 
  }*/

  public void addEntityList(Entity entity){
    this.pokemonItemList.add(entity);
  }

  public void removeEntityList(Entity entity){
    this.pokemonItemList.remove(entity);
  }

  public void positionRandomizer(){
    RandomValues r = new RandomValues();
    for (int i = 0; i < this.pokemonItemList.size(); i++) {
      int x, y;
      while (this.island_map[x = r.rollTheDice(1, this.getLines()-1)][y = r.rollTheDice(1, this.getColumns()-1)] != null){
        x = r.rollTheDice(1, this.getLines()-1);
        y = r.rollTheDice(1, this.getColumns()-1);
      }
      this.addEntity(this.pokemonItemList.get(i), new Position(x, y));
    }
  }

	public void printMap(){
		
		for(int i = 0; i < this.getLines(); i++){
			System.out.println();
			for(int j = 0; j < this.getColumns(); j++){

				if(this.island_map[i][j] != null){
					System.out.print(this.island_map[i][j].toString()+ " ");
				}
				else{
					System.out.print("* ");
				}
			}
		}
		System.out.println();

		for(int j = 0; j < 100; j++){
			System.out.println();
		}
	}
}




