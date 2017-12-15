package com.wannabe.ontop;

public class World {
	private Player playerOne;
	private Player playerTwo;
	private Map map;
	
	World(WannaBeOnTop wannaGame) {
		playerOne = new Player(140,140);
		playerTwo = new Player(700,140);
		map = new Map();
	}
	
	Player getPlayerOne() {
		return playerOne;
	}
	
	Player getPlayerTwo() {
		return playerTwo;
	}
	
	Map getMap() {
		return map;
	}
}
