package com.wannabe.ontop;

public class World {
	private Player playerOne;
	private Player playerTwo;
	private Map map;
	
	public static int initialState = 0;
	public static int playingState = 1;
	public static int playerOneWin = 2;
	public static int playerTwoWin = 3;
	
	public int gameState = initialState;
	
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
	
	public void gameRunning() {
		gameState = playingState;
	}
	
	public void playerOneWin() {
		gameState = playerOneWin;
	}
	
	public void playerTwoWin() {
		gameState = playerOneWin;
	}
	
	public void restart() {
		gameState = playingState;
	}
}
