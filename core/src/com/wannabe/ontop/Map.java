package com.wannabe.ontop;

public class Map {
	
    private String[] MAP = new String [] {
            "............",
            "............",
            "............",
            "............",
            "............",
            "------------",
            "############"    
    };
	
    private int height;
    private int width;
 
    public Map() {
        height = MAP.length;
        width = MAP[0].length();
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasGroundAt(int r, int c) {
        return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasGrassAt(int r, int c) {
        return MAP[r].charAt(c) == '-';
    }
}
