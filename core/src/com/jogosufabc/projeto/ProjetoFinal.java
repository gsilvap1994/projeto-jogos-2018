package com.jogosufabc.projeto;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.jogosufabc.projeto.screen.AbstractScreen;
import com.jogosufabc.projeto.screen.CreditsScreen;
import com.jogosufabc.projeto.screen.GameScreen;
import com.jogosufabc.projeto.screen.OptionsScreen;
import com.jogosufabc.projeto.screen.StartScreen;
import com.jogosufabc.projeto.utils.Options;
//import com.jogosufabc.projeto.screen.GameScreen;

public class ProjetoFinal extends Game {
	private AbstractScreen currentScreen;
	

	private OptionsScreen optionsScreen;
	private StartScreen startScreen;
	private GameScreen gameScreen;
	private CreditsScreen creditsScreen;
	private Options options; 

	public final static int MENU = 0;
	public final static int OPTIONS = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;
	
	
	
	@Override
    public void create() {
//		startScreen = new StartScreen("START");
//		setScreen(startScreen);
		optionsScreen = new OptionsScreen("OPTIONS");
		setScreen(optionsScreen);
		
    }
	
	public Options getPreferences() {
		return this.options;
	}
	
	public void render(float delta) {
		currentScreen.render(Gdx.graphics.getDeltaTime());
	}
	
	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(startScreen == null) startScreen = new StartScreen("START");
	                        this.setScreen(startScreen);
				break;
			case OPTIONS:
				if(optionsScreen == null) optionsScreen = new OptionsScreen("OPTIONS");
				this.setScreen(optionsScreen);
				break;
			case APPLICATION:
				if(gameScreen == null) gameScreen = new GameScreen("GAME");
				this.setScreen(gameScreen);
				break;
			case ENDGAME:
				if(creditsScreen == null) creditsScreen = new CreditsScreen("CREDITS");
				this.setScreen(creditsScreen);
				break;
		}
	}
}
