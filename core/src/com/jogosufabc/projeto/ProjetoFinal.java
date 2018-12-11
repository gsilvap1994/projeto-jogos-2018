package com.jogosufabc.projeto;

import com.badlogic.gdx.Game;
import com.jogosufabc.projeto.screen.AbstractScreen;
import com.jogosufabc.projeto.screen.GameScreen;

public class ProjetoFinal extends Game {
	private AbstractScreen currentScreen;
	
	@Override
    public void create() {
		setScreen(new GameScreen("GAME"));
//		setScreen(new StartScreen("START"));
//		currentScreen = new StartScreen("START");
//		currentScreen = new CreditScreen("CREDITS");
//		setScreen(new CreditScreen("CREDITS"));
    }
	
//	public void render() {
//		currentScreen.render(Gdx.graphics.getDeltaTime());
//	}
}
