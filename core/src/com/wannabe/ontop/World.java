package com.wannabe.ontop;

public class World {
	private Player playerTwo;
	private WannaBeOnTop wannaGame;
	private Map map;
	
	World(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		playerTwo = new Player(630,210);
		map = new Map();
	}
	
	Player getPlayerTwo() {
		return playerTwo;
	}
	
	Map getMap() {
		return map;
	}
}
