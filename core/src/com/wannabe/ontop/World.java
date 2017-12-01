package com.wannabe.ontop;

public class World {
	private Player playerTwo;
	private WannaBeOnTop wannaGame;
	
	World(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		playerTwo = new Player(630,70);
	}
	
	Player getPlayerTwo() {
		return playerTwo;
	}
}
