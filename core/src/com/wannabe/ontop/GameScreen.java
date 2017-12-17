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
	private Player cloudOne;
	private Player cloudTwo;
	
	World world;
	WorldRenderer worldRenderer;
	
	private int cloudOneMoving = Player.DIRECTION_RIGHT;
	private int cloudTwoMoving = Player.DIRECTION_LEFT;
	
	public GameScreen(WannaBeOnTop wannaGame) {
		this.wannaGame = wannaGame;
		
		world = new World(wannaGame);
		worldRenderer = new WorldRenderer(wannaGame, world);
		
		new Texture("slimePurpleBan.png");
		playerOne = world.getPlayerOne();
		
		new Texture("slimeBlueBan.png");
		playerTwo = world.getPlayerTwo();
		
		new Texture("cloud1.png");
		new Texture("cloud2.png");
		cloudOne = world.getCloudOne();
		cloudTwo = world.getCloudTwo();
	}
	
    @Override
    public void render(float delta) {
        update(delta);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
    
    private void update(float delta) {
    	if(world.gameState ==  world.initialState) {
    		moveConstantly(cloudOne, cloudOneMoving);
    		moveConstantly(cloudTwo, cloudTwoMoving);
    		
    		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
	    		world.gameRunning();
	        }
    	} else if((world.gameState == world.playerOneWin) || (world.gameState == world.playerTwoWin)) {
    		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
	    		world.restart();
	        }
    	}
    	
    	if(world.gameState == world.playingState) {
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
    	}
        
        if(checkCollision(playerOne, playerTwo)) {
        	world.playerOneWin();
        } else if(checkCollision(playerTwo, playerOne)) {
        	world.playerTwoWin();
        }
        
        if(world.gameState == world.playerOneWin) {
	        jumpEndlessly(playerOne);
        } else if(world.gameState == world.playerTwoWin) {
        	jumpEndlessly(playerTwo);
        }
    }
    
    private boolean checkCollision(Player one, Player two) {
    	Vector2 posOne = one.getPosition();
    	Vector2 posTwo = two.getPosition();
    	if((posOne.y - posTwo.y <= 30 && posOne.y - posTwo.y >= 25) && (Math.abs(posOne.x - posTwo.x) <= 55)) {
    		 return true;
    	}
    	return false;
    }
    
    private void moveConstantly(Player player, int dir) {
		player.moveSlowly(dir);
		if(player.getPosition().x > 711) {
			dir = Player.DIRECTION_LEFT;
		} else if(player.getPosition().x < 0) {
			dir = Player.DIRECTION_RIGHT;
		}
    }
    
    private void jumpEndlessly(Player player) {
	    if(player.getPosition().y > 145) {
	    	player.gravityFall();
	    }
	    player.verticalMove();
	    if(player.getPosition().y < 140) {
	    	player.jump();
	    }
    }
}