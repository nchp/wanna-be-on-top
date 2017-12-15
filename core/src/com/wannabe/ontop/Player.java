package com.wannabe.ontop;

import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_LEFT = 3;
    public static final int DIRECTION_STILL = 0;
    
    public float vy;
    
    public int groundPosition = 140;    
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,1},
        {1,0},
        {-1,0}
    };
    
    public static int counter = 4;
    
    public Player(int x, int y) {
        position = new Vector2(x,y);
    }
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move(int dir) { 
        position.x += 5 * DIR_OFFSETS[dir][0];
    }
    
    public void gravityFall() {
    	vy -= 0.5;
    }
    
    public void jump() {
    	vy += 10;
    }
    
    public void verticalMove() {
    	position.y += vy;
    }

	public void setToGround() {
		vy = 0;
		position.y = groundPosition;
	}
}
