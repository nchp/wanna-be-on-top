package com.wannabe.ontop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private WannaBeOnTop wannaGame;
	private Texture playerTwoImg;
	private Player playerTwo;
	
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		
		world = new World(wannaGame);
		worldRenderer = new WorldRenderer(wannaGame, world);
		
		playerTwoImg = new Texture("slimeBlueBan.png");
		playerTwo = world.getPlayerTwo();
		
	}
	
    @Override
    public void render(float delta) {
        update(delta);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
    
    private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		playerTwo.move(Player.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	playerTwo.move(Player.DIRECTION_RIGHT);
        }
        
        if(Gdx.input.isKeyJustPressed(Keys.UP)) {
        	playerTwo.jump();
        }
        if(playerTwo.getPosition().y > 215) {
        	playerTwo.gravityFall();
        }
        playerTwo.verticalMove();
        if(playerTwo.getPosition().y < 210) {
        	playerTwo.setToGround();
        }
    }
}