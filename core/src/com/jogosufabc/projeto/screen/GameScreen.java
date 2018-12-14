package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.stages.GameStage;
import com.jogosufabc.projeto.utils.CustomMusic;

public class GameScreen implements Screen {
	
	private ProjetoFinal parent;
	private GameStage stage;
	private CustomMusic music;


	public GameScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		
		
		
		stage = new GameStage(projetoFinal, this);
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		music = new CustomMusic("audio/SweetDreams.mp3", true, parent.getPreferences());
		music.play();
	}
	
	public void stopMusic() {
		this.music.pause();
		this.music.dispose();
	
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		stage.act(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, true);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		
	}

}
