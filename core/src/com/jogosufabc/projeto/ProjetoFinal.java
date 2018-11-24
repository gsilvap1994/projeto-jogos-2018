package com.jogosufabc.projeto;

import com.badlogic.gdx.Game;
import com.jogosufabc.projeto.screen.GameScreen;

public class ProjetoFinal extends Game {

	
	@Override
    public void create() {
		setScreen(new GameScreen());
    }
}
