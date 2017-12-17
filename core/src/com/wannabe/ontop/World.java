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
		playerOne = new Player(83,140);
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
		gameState = playerTwoWin;
	}
	
	public void restart() {
		gameState = playingState;
		playerOne.getPosition().x = 83;
		playerOne.getPosition().y = 140;
		playerTwo.getPosition().x = 700;
		playerTwo.getPosition().y = 140;
	}
}
