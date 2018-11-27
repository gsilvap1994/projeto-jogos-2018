package com.jogosufabc.projeto;

import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.jogosufabc.projeto.screen.AbstractScreen;
import com.jogosufabc.projeto.screen.GameScreen;
//import com.jogosufabc.projeto.screen.GameScreen;

public class ProjetoFinal extends Game {
//	private AbstractScreen currentScreen;
	
	@Override
    public void create() {
		setScreen(new GameScreen("GAME"));
//		currentScreen = new StartScreen("START");	
    }
	
//	public void render() {
//		currentScreen.render(Gdx.graphics.getDeltaTime());
//	}
}
