package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
    private SpriteBatch batch;
	private World world;
	private Texture playerOneImg;
	private Texture playerTwoImg;
	private Texture initialPage;
	private Texture playerOneWinPage;
	private Texture playerTwoWinPage;
	private MapRenderer mapRenderer;
	
	private Texture startTag;
	private Texture restartTag;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerOneImg = new Texture("slimePurpleBan.png");
    	playerTwoImg = new Texture("slimeBlueBan.png");
    	initialPage = new Texture("initialPage.png");
    	playerOneWinPage = new Texture("winPage1.png");
    	playerTwoWinPage = new Texture("winPage1.png");
    	startTag = new Texture("pressStartTag.png");
    	restartTag = new Texture("pressRestartTag.png");
    	mapRenderer = new MapRenderer(wannaGame.batch, world.getMap());
    }
	
    public void render(float delta) {
    	mapRenderer.render();
    	if(world.gameState == world.playingState) {
	    	Vector2 posOne = world.getPlayerOne().getPosition();
	    	Vector2 posTwo = world.getPlayerTwo().getPosition();
	        batch.begin();
	        batch.draw(playerOneImg, posOne.x, posOne.y);
	        batch.draw(playerTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} else if(world.gameState == world.initialState) {
	        batch.begin();
	        	batch.draw(startTag, 210, 410);
	        batch.end();
    	} else if(world.gameState == world.playerOneWin) {
    		mapRenderer.render();
	    	Vector2 posOne = world.getPlayerOne().getPosition();
	        batch.begin();
	        	batch.draw(restartTag, 210, 410);
	        	batch.draw(playerOneImg, posOne.x, posOne.y);
	        batch.end();
    	} else if(world.gameState == world.playerTwoWin) {
    		mapRenderer.render();
	    	Vector2 posTwo = world.getPlayerTwo().getPosition();
	        batch.begin();
	        	batch.draw(restartTag, 140, 360);
	        	batch.draw(playerTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	}
    }
}
