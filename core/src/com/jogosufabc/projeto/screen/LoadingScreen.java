package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.utils.Constants;

public class LoadingScreen implements Screen {
	
	private ProjetoFinal parent;
	private Stage stage;
	private BitmapFont font;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private GlyphLayout glyphLayout_title;
	
	public LoadingScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font/vegan-style.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 40;
		parameter.color = Color.WHITE;
		font = generator.generateFont(parameter);
		glyphLayout_title = new GlyphLayout();
		glyphLayout_title.setText(font, "LOADING...");
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.getBatch().begin();
		font.draw(stage.getBatch(), glyphLayout_title, Constants.GAME_WIDTH/2 - glyphLayout_title.width/2,
				Constants.GAME_HEIGHT/2 - glyphLayout_title.height/2);
		stage.getBatch().end();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
