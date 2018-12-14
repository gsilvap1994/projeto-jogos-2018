package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.utils.Constants;
import com.jogosufabc.projeto.utils.CustomMusic;

public class CreditScreen extends Stage implements Screen {

	private ProjetoFinal parent;
	private Stage stage;
	private Texture texture;
	private CustomMusic music;
	private BitmapFont font;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private GlyphLayout glyphLayout_title;
	private GlyphLayout glyphLayout_nome1;
	private GlyphLayout glyphLayout_nome2;
	private GlyphLayout glyphLayout_nome3;
	private GlyphLayout glyphLayout_prof;
	private GlyphLayout glyphLayout_continue;

	public CreditScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		stage = new Stage(new ScreenViewport());
		texture = new Texture(Gdx.files.internal("images/creditos.jpg"));
		
		
		
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font/vegan-style.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 25;
		parameter.color = Color.WHITE;
		font = generator.generateFont(parameter);
		glyphLayout_title = new GlyphLayout();
		new GlyphLayout();
		glyphLayout_nome1 = new GlyphLayout();
		glyphLayout_nome2 = new GlyphLayout();
		glyphLayout_nome3 = new GlyphLayout();
		glyphLayout_prof = new GlyphLayout();
		glyphLayout_continue = new GlyphLayout();
		glyphLayout_title.setText(font, "CRÉDITOS");
		glyphLayout_nome1.setText(font, "Gabriel");
		glyphLayout_nome2.setText(font, "Henrique");
		glyphLayout_nome3.setText(font, "Murilo");
		glyphLayout_prof.setText(font, "Prof. Isidro");
		glyphLayout_continue.setText(font, "Press any key to continue.");
		
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		music = new CustomMusic("audio/menumusic.mp3", true, parent.getPreferences());
		music.play();
		Gdx.input.setInputProcessor(this);	
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.getBatch().begin();
		stage.getBatch().draw(texture, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, 0, 0, texture.getWidth(),
				texture.getHeight(), false, false);
		font.draw(stage.getBatch(), glyphLayout_title, Constants.GAME_WIDTH - 400, Constants.GAME_HEIGHT);
		font.draw(stage.getBatch(), glyphLayout_nome1, Constants.GAME_WIDTH - 400, Constants.GAME_HEIGHT - 75);
		font.draw(stage.getBatch(), glyphLayout_nome2, Constants.GAME_WIDTH - 400, Constants.GAME_HEIGHT - 125);
		font.draw(stage.getBatch(), glyphLayout_nome3, Constants.GAME_WIDTH - 400, Constants.GAME_HEIGHT - 175);
		font.draw(stage.getBatch(), glyphLayout_prof,  Constants.GAME_WIDTH - 400,  Constants.GAME_HEIGHT - 250);
		font.draw(stage.getBatch(), glyphLayout_continue, 20, 100);
		stage.getBatch().end();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getBatch().begin();
		stage.getBatch().draw(texture, 0, 0, width, height, 0, 0, texture.getWidth(),
				texture.getHeight(), false, false);
		font.draw(stage.getBatch(), glyphLayout_title, width/2 - glyphLayout_title.width/2, height);
		font.draw(stage.getBatch(), glyphLayout_nome1, width/2 - glyphLayout_nome1.width/2, height - 125);
		font.draw(stage.getBatch(), glyphLayout_nome2, width/2 - glyphLayout_nome2.width/2, height - 175);
		font.draw(stage.getBatch(), glyphLayout_nome3, width/2 - glyphLayout_nome3.width/2, height - 225);
		font.draw(stage.getBatch(), glyphLayout_prof,  width/2 - glyphLayout_prof.width/2,  height - 300);
		stage.getBatch().end();
	}
	
	@Override
	public boolean keyDown(int keycode) {

		parent.changeScreen(ProjetoFinal.START);
		music.pause();
		music.dispose();
		return true;
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
		
	}

}
