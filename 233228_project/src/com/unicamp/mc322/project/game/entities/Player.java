package com.unicamp.mc322.project.game.entities;

import java.util.LinkedList;
import com.unicamp.mc322.project.game.entities.items.*;
import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.map.Island;

public class Player extends Entity{

	private String name;
	private Island currentIsland;
	private LinkedList<Pokemon> pokemons; // lista de pokemons
	private LinkedList<Item> items; // lista de itens

	public Player(String name, Position pos){

		super(pos);
		this.name = name;
		this.pokemons = new LinkedList<Pokemon>();
		this.items = new LinkedList<Item>();
		this.currentIsland = null;
	}

	public LinkedList<Pokemon> getPokemons(){
		return this.pokemons;
	}

	public LinkedList<Item> getItems(){
		return this.items;
	}

	public String getName(){
		return this.name;
	}

	public Island getCurrentIsland(){
		return this.currentIsland;
	}

	public void setCurrentIsland(Island newIsland){
		this.currentIsland = newIsland;
	}

	public void addPokemon(Pokemon pk){
		this.getPokemons().add(pk);
	}

	public void addItem(Item i){
		this.getItems().add(i);
	}

	public void listPokemons(){

		int c = 1;
		System.out.println("POKEMONS DE "+ this.getName());
		for(Pokemon p : this.getPokemons()){

			System.out.println(c + ") "+ p.getName());
			c++;
		}
		System.out.println();
	}

	public void listItems(){

		int c = 1;
		System.out.println("ITENS DE "+ this.getName());
		for(Item i : this.getItems()){

			System.out.println(c + ") "+ i.getName());
			c++;
		}
		System.out.println();
	}

	public Pokemon selectPokemon(int i){

		Pokemon selected = null;
		try{
			selected = this.getPokemons().get(i-1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Posição inválida.");
		}
		return selected;
	}

	public Item selectItem(int i){

		Item selected = null;
		try{
			selected = this.getItems().get(i-1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Posição inválida.");
		}
		return selected;
	}

	@Override
	public String toString(){
		return "P";
	}
}

