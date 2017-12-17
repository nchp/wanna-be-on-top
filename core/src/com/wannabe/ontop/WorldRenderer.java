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
	private Texture cloudOneImg;
	private Texture cloudTwoImg;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerOneImg = new Texture("slimePurpleBan.png");
    	playerTwoImg = new Texture("slimeBlueBan.png");
    	startTag = new Texture("pressStartTag.png");
    	restartTag = new Texture("pressRestartTag.png");
    	cloudOneImg = new Texture("cloud1.png");
    	cloudTwoImg = new Texture("cloud2.png");
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
	        batch.draw(cloudOneImg, 160, 330);
	        batch.draw(cloudTwoImg, 490, 220);
	        batch.end();
    	} else if(world.gameState == world.initialState) {
    		Vector2 posOne = world.getCloudOne().getPosition();
	    	Vector2 posTwo = world.getCloudTwo().getPosition();
	        batch.begin();
	        batch.draw(startTag, 210, 410);
	        batch.draw(cloudOneImg, posOne.x, posOne.y);
	        batch.draw(cloudTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} else if(world.gameState == world.playerOneWin) {
	    	Vector2 posSlime = world.getPlayerOne().getPosition();
    		Vector2 posOne = world.getCloudOne().getPosition();
	    	Vector2 posTwo = world.getCloudTwo().getPosition();
	        batch.begin();
	        batch.draw(restartTag, 210, 410);
	        batch.draw(playerOneImg, posSlime.x, posSlime.y);
	        batch.draw(cloudOneImg, posOne.x, posOne.y);
	        batch.draw(cloudTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	} else if(world.gameState == world.playerTwoWin) {
	    	Vector2 posSlime = world.getPlayerTwo().getPosition();
    		Vector2 posOne = world.getCloudOne().getPosition();
	    	Vector2 posTwo = world.getCloudTwo().getPosition();
	        batch.begin();
	        batch.draw(restartTag, 210, 410);
	       	batch.draw(playerTwoImg, posSlime.x, posSlime.y);
	        batch.draw(cloudOneImg, posOne.x, posOne.y);
	        batch.draw(cloudTwoImg, posTwo.x, posTwo.y);
	        batch.end();
    	}
    }
}
