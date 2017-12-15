package com.wannabe.ontop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private WannaBeOnTop wannaGame;
	private Player playerOne;
	private Player playerTwo;
	
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		
		world = new World(wannaGame);
		worldRenderer = new WorldRenderer(wannaGame, world);
		
		new Texture("slimePurpleBan.png");
		playerOne = world.getPlayerOne();
		
		new Texture("slimeBlueBan.png");
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
    	// purpleOne
    	if(Gdx.input.isKeyPressed(Keys.A)) {
    		playerOne.move(Player.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.D)) {
        	playerOne.move(Player.DIRECTION_RIGHT);
        }
        
        if(Gdx.input.isKeyJustPressed(Keys.W)) {
        	playerOne.jump();
        }
        if(playerOne.getPosition().y > 145) {
        	playerOne.gravityFall();
        }
        playerOne.verticalMove();
        if(playerOne.getPosition().y < 140) {
        	playerOne.setToGround();
        }
    	
    	// blueTwo
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		playerTwo.move(Player.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	playerTwo.move(Player.DIRECTION_RIGHT);
        }
        
        if(Gdx.input.isKeyJustPressed(Keys.UP)) {
        	playerTwo.jump();
        }
        if(playerTwo.getPosition().y > 145) {
        	playerTwo.gravityFall();
        }
        playerTwo.verticalMove();
        if(playerTwo.getPosition().y < 140) {
        	playerTwo.setToGround();
        }
        
        /*
        if((playerOne.getPosition().y - playerTwo.getPosition().y <= 30 && playerOne.getPosition().y - playerTwo.getPosition().y >= 25) && (Math.abs(playerOne.getPosition().x - playerTwo.getPosition().x) <= 55)) {
        	playerOne.jump();
        }
        */
        
        checkCollision(playerOne, playerTwo);
        checkCollision(playerTwo, playerOne);
    }
    
    private void checkCollision(Player one, Player two) {
    	Vector2 posOne = one.getPosition();
    	Vector2 posTwo = two.getPosition();
    	if((posOne.y - posTwo.y <= 30 && posOne.y - posTwo.y >= 25) && (Math.abs(posOne.x - posTwo.x) <= 55)) {
    		 one.jump();
    	}
    }
    
}