package com.wannabe.ontop;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	private WannaBeOnTop wannaGame;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
	}
	
    @Override
    public void render(float delta) {
        System.out.println("Hello " + delta);
    }

}
