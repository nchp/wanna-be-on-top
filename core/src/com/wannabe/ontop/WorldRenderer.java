package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
    private SpriteBatch batch;
	private World world;
	private Texture playerOneImg;
	private Texture playerTwoImg;
	private MapRenderer mapRenderer;
	
	private Texture startTag;
	private Texture restartTag;
	private Texture nameTag;
	
	private Texture cloudOneImg;
	private Texture cloudTwoImg;
	
	private Texture playerOneDie;
	private Texture playerTwoDie;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerOneImg = new Texture("slimePurpleBan.png");
    	playerTwoImg = new Texture("slimeBlueBan.png");
    	startTag = new Texture("pressStartTag.png");
    	restartTag = new Texture("pressRestartTag.png");
    	nameTag = new Texture("name.png");
    	cloudOneImg = new Texture("cloud1.png");
    	cloudTwoImg = new Texture("cloud2.png");
    	playerOneDie = new Texture("slimePurpleBee.png");
    	playerTwoDie = new Texture("slimeBlueBee.png");
    	mapRenderer = new MapRenderer(wannaGame.batch, world.getMap());
    }
	
    public void render(float delta) {
    	mapRenderer.render();
    	Vector2 posOne = world.getPlayerOne().getPosition();
    	Vector2 posTwo = world.getPlayerTwo().getPosition();
		Vector2 posCloudOne = world.getCloudOne().getPosition();
    	Vector2 posCloudTwo = world.getCloudTwo().getPosition();
    	
    	if(world.gameState == world.playingState) {	    	
	        batch.begin();
	        batch.draw(cloudOneImg, posCloudOne.x, posCloudOne.y);
	        batch.draw(cloudTwoImg, posCloudTwo.x, posCloudTwo.y);
	        batch.draw(playerOneImg, posOne.x, posOne.y);
	        batch.draw(playerTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} 
    	
    	else if(world.gameState == world.initialState) {	    	
	        batch.begin();
	        batch.draw(startTag, 210, 410);
	        batch.draw(cloudOneImg, posCloudOne.x, posCloudOne.y);
	        batch.draw(cloudTwoImg, posCloudTwo.x, posCloudTwo.y);
	        batch.draw(nameTag, 210, 350);
	        batch.end();
    	} 
    	
    	else if(world.gameState == world.playerOneWin) {
	        batch.begin();
	        batch.draw(restartTag, 210, 410);
	        batch.draw(cloudOneImg, posCloudOne.x, posCloudOne.y);
	        batch.draw(cloudTwoImg, posCloudTwo.x, posCloudTwo.y);
	        batch.draw(playerTwoDie, posTwo.x, 140);
	        batch.draw(playerOneImg, posOne.x, posOne.y);
	        batch.end();
    	} 
    	
    	else if(world.gameState == world.playerTwoWin) {	    	
	        batch.begin();
	        batch.draw(cloudOneImg, posCloudOne.x, posCloudOne.y);
	        batch.draw(cloudTwoImg, posCloudTwo.x, posCloudTwo.y);
	        batch.draw(restartTag, 210, 410);
	        batch.draw(playerOneDie, posOne.x, 140);
	       	batch.draw(playerTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	}
    }
}
