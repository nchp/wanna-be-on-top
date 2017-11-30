package com.wannabe.ontop;

import com.badlogic.gdx.math.Vector2;

public class RightPlayer {
    private Vector2 position;
    
    public RightPlayer(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
}
