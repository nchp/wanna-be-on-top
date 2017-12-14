package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
    private WannaBeOnTop wannaGame;
	private SpriteBatch batch;
	private World world;
	private Texture playerTwoImg;
	private MapRenderer mapRenderer;

	public WorldRenderer(WannaBeOnTop wannaGame, World world) {
    	this.wannaGame = wannaGame;
    	batch = wannaGame.batch;
    	this.world = world;
    	
    	playerTwoImg = new Texture("player1.png");
    	mapRenderer = new MapRenderer(wannaGame.batch, world.getMap());
    }
	
    public void render(float delta) {
    	mapRenderer.render();
    	
    	Vector2 pos = world.getPlayerTwo().getPosition();
        batch.begin();
        batch.draw(playerTwoImg, pos.x, pos.y);
        batch.end();
    }
}
