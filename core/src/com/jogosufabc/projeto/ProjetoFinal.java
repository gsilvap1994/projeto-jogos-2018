package com.jogosufabc.projeto;

import com.badlogic.gdx.Game;
import com.jogosufabc.projeto.screen.CreditScreen;
import com.jogosufabc.projeto.screen.GameScreen;
import com.jogosufabc.projeto.screen.GetUsernameScreen;
import com.jogosufabc.projeto.screen.LeaderBoardScreen;
import com.jogosufabc.projeto.screen.LoadingScreen;
import com.jogosufabc.projeto.screen.OptionsScreen;
import com.jogosufabc.projeto.screen.StartScreen;

public class ProjetoFinal extends Game {

	private StartScreen startScreen;
	private GameScreen gameScreen;
	private OptionsScreen optionsScreen;
	private CreditScreen creditScreen;
	private LeaderBoardScreen leaderBoardScreen;
	private AppPreferences appPreferences;
	private GetUsernameScreen getUsernameScreen;
	private LoadingScreen loadingScreen;

	public final static int START = 0;
	public final static int OPTIONS = 1;
	public final static int GAME = 2;
	public final static int CREDITS = 3;
	public final static int LEADERBOARD = 4;
	public final static int SETUSERNAME = 5;
	public final static int LOADING = 6;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		appPreferences = new AppPreferences();
		startScreen = new StartScreen(this);
		
		setScreen(startScreen);
		

	}
	
	public AppPreferences getPreferences() {
		return this.appPreferences;
	}

	public void changeScreen(int screen) {
		switch (screen) {
		case START:
			if (startScreen == null)
				startScreen = new StartScreen(this);
			this.setScreen(startScreen);
			break;
		case OPTIONS:
			if (optionsScreen == null)
				optionsScreen = new OptionsScreen(this);
			this.setScreen(optionsScreen);
			break;
		case GAME:
			gameScreen = new GameScreen(this);
			this.setScreen(gameScreen);
			break;
		case CREDITS:
			if (creditScreen == null)
				creditScreen = new CreditScreen(this);
			this.setScreen(creditScreen);
			break;
		case LEADERBOARD:
			if(leaderBoardScreen == null)
				leaderBoardScreen = new LeaderBoardScreen(this);
			this.setScreen(leaderBoardScreen);
			break;
		case SETUSERNAME:
				getUsernameScreen = new GetUsernameScreen(this);
			this.setScreen(getUsernameScreen);
			break;
		case LOADING: 
			if(loadingScreen == null) loadingScreen = new LoadingScreen(this);
			this.setScreen(loadingScreen);
			break;
		}
		
		
 
	}

}
