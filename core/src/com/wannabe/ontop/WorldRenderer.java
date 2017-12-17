package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
    private SpriteBatch batch;
	private World world;
	private Texture playerOneImg;
	private Texture playerTwoImg;
	private Texture cloudOneImg;
	private Texture cloudTwoImg;
	private Texture initialPage;
	private MapRenderer mapRenderer;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerOneImg = new Texture("slimePurpleBan.png");
    	playerTwoImg = new Texture("slimeBlueBan.png");
    	cloudOneImg = new Texture("cloud1.png");
    	cloudTwoImg = new Texture("cloud2.png");
    	initialPage = new Texture("initialPage.png");
    	mapRenderer = new MapRenderer(wannaGame.batch, world.getMap());
    }
	
    public void render(float delta) {
    	if(world.gameState == world.playingState) {
	    	mapRenderer.render();
	    	Vector2 posOne = world.getPlayerOne().getPosition();
	    	Vector2 posTwo = world.getPlayerTwo().getPosition();
	        batch.begin();
	        batch.draw(playerOneImg, posOne.x, posOne.y);
	        batch.draw(playerTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} else if(world.gameState == world.initialState) {
	    	Vector2 posOne = world.getCloudOne().getPosition();
	    	Vector2 posTwo = world.getCloudTwo().getPosition();
	        batch.begin();
	        batch.draw(initialPage, 0, 0);
	        batch.draw(cloudOneImg, posOne.x, posOne.y);
	        batch.draw(cloudTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} else if(world.gameState == world.playerOneWin) {
    		
    	} else if(world.gameState == world.playerTwoWin) {
    		
    	}
    }
}
