package com.wannabe.ontop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private WannaBeOnTop wannaGame;
	private Texture playerTwoImg;
	private Player playerTwo;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		playerTwoImg = new Texture("player1.png");
		playerTwo = new Player(100,100);
	}
	
    @Override
    public void render(float delta) {
    	update(delta);
    	
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        SpriteBatch batch = wannaGame.batch;
        batch.begin();
        batch.draw(playerOneImg, x, y);
        batch.end();
    }
    
    private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 5;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 5;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y += 5;
        }
    }
}