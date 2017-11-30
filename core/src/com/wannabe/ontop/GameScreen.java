package com.wannabe.ontop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private WannaBeOnTop wannaGame;
	private Texture playerOneImg;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		playerOneImg = new Texture("player1.png");
	}
	
    @Override
    public void render(float delta) {
        SpriteBatch batch = wannaGame.batch;
        batch.begin();
        batch.draw(playerOneImg, 100, 100);
        batch.end();
    }
}