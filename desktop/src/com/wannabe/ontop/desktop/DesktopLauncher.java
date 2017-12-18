package com.wannabe.ontop.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wannabe.ontop.WannaBeOnTop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WannaBeOnTop.WIDTH;
		config.height = WannaBeOnTop.HEIGHT;
		new LwjglApplication(new WannaBeOnTop(), config);
	}
}