package com.unicamp.mc322.project.game.map;
import java.util.LinkedList;
import com.unicamp.mc322.project.game.position.Position;
import com.unicamp.mc322.project.game.Type;
import com.unicamp.mc322.project.game.entities.*;
import com.unicamp.mc322.project.game.entities.map_objects.Bridge;
import com.unicamp.mc322.project.game.entities.map_objects.Portal;
import com.unicamp.mc322.project.game.entities.map_objects.Stair;

public class World{

 private LinkedList<Island> IslandsList;

 //variaveis para criação de mundo
	Island galapagos;
	Island krakatoa1Floor;
	Island krakatoa2Floor;
	Island easterIsland;
	Player player;
	Bridge bridge1, bridge2;
	Portal portal1, portal2;
	Stair stair1;


  public World(){
    this.IslandsList = new LinkedList<Island>();
  }


public LinkedList<Island> getIslands(){
  return this.IslandsList;
}

public void addIsland(Island island){
  this.getIslands().add(island);
}

public void createBasicWorld(Player player){
  //ilhas
  galapagos = new Island(3,4,Type.WATER,Type.GRASS);
  krakatoa1Floor = new Island(5,5,Type.FIRE);
  krakatoa1Floor = new Island(5,5,Type.FIRE, Type.DRAGON);
  easterIsland = new Island(4, 4, Type.ELECTRIC,Type.PSYCHIC);

  //travessias
  bridge1 = new Bridge(new Position(0,0), galapagos, krakatoa1Floor, new Position(0,4));
  bridge2 = new Bridge(new Position(0,0), krakatoa1Floor, easterIsland, new Position(0,3));
  portal1 = new Portal(new Position(2,3), galapagos, krakatoa2Floor, new Position(0,4));
  portal2 = new Portal(new Position(0,0),  krakatoa2Floor, easterIsland, new Position(3,0));
  stair1 = new Stair(new Position(3,2), krakatoa1Floor, krakatoa2Floor, new Position(3, 2));

  galapagos.addEntity(player, new Position(0,1));
  galapagos.addEntity(bridge1, new Position(0,0));
  galapagos.addEntity(portal1, new Position(2,3));
  krakatoa1Floor.addEntity(bridge1, new Position(0,4));
  krakatoa1Floor.addEntity(bridge2, new Position(0,0));
  krakatoa1Floor.addEntity(stair1, new Position(3,2));
  krakatoa2Floor.addEntity(portal1, new Position(0,4));
  krakatoa2Floor.addEntity(portal2, new Position(0,0));
  krakatoa2Floor.addEntity(stair1, new Position(3,2));
  easterIsland.addEntity(bridge2, new Position(0,3));
  easterIsland.addEntity(portal2, new Position(3,0));

  //pokemons

  //items



  
}

}