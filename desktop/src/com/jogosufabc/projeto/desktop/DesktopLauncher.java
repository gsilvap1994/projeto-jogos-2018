package com.jogosufabc.projeto.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.GAME_WIDTH;
		config.height = Constants.GAME_HEIGHT;
		new LwjglApplication(new ProjetoFinal(), config);
	}
}
