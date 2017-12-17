package com.wannabe.ontop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapRenderer {
    private Map map;
    private SpriteBatch batch;
    
    private Texture groundImage;
    private Texture grassImage;
    private Texture skyImage;
	private Texture cloudOneImg;
	private Texture cloudTwoImg;
    
    public MapRenderer(SpriteBatch batch, Map maze) {
        this.map = map;
        this.batch = batch;
        
        map = new Map();
        
        groundImage = new Texture("grassCenter.png");
        grassImage = new Texture("grassMid.png");
        skyImage = new Texture("bg.png");
    	cloudOneImg = new Texture("cloud1.png");
    	cloudTwoImg = new Texture("cloud2.png");
        
    }
 
    public void render() {
        batch.begin();
        for(int r = 0; r < map.getHeight(); r++) {
            for(int c = 0; c < map.getWidth(); c++) {
                int x = (c * 70);
                int y = ((6 - r) * 70);
 
                if(map.hasGroundAt(r, c)) {
                    batch.draw(groundImage, x, y);
                } else if(map.hasGrassAt(r, c)) {
                    batch.draw(grassImage, x, y);
                } else {
                	batch.draw(skyImage, x, y);
                }
            }
        }
        batch.draw(cloudOneImg, 160, 330);
        batch.draw(cloudTwoImg, 490, 220);
        batch.end();
    }
}
