package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
    private WannaBeOnTop wannaGame;
	private SpriteBatch batch;
	private World world;
	private Texture playerTwoImg;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	this.wannaGame = wannaGame;
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerTwoImg = new Texture("player1.png");
    }
}
