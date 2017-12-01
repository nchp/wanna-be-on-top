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
	private static double G = 0.5;
	private static double vy, vyMax = 5;
	private static int groundPosition = 70;
	
	Vector2 pos;
	
	World world;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		
		world = new World(wannaGame);
		
		playerTwoImg = new Texture("player1.png");
		playerTwo = world.getPlayerTwo();
		
	}
	
    @Override
    public void render(float delta) {
    	update(delta);
    	
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        SpriteBatch batch = wannaGame.batch;
        batch.begin();
        pos = playerTwo.getPosition();
        batch.draw(playerTwoImg, pos.x, pos.y);
        batch.end();
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
        if(playerTwo.getPosition().y > 75) {
        	playerTwo.gravityFall();
        }
        if(playerTwo.getPosition().y < 70) {
        	playerTwo.setToGround();
        }
        playerTwo.verticalMove();
    }
}