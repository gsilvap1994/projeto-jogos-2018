package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.jogosufabc.projeto.utils.Constants;

public class OptionsScreen extends AbstractScreen {
	private Texture texture;
	private SpriteBatch spriteBatch;
	private Music music;
	private BitmapFont font;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private GlyphLayout glyphLayout_title;
	private GlyphLayout glyphLayout_start;
	
	public OptionsScreen(String id) {
		super(id);
		spriteBatch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("index.jpg"));
		
		// opening music
		music = Gdx.audio.newMusic(Gdx.files.internal("audio/opening.mp3"));
		music.setLooping(true);
		music.play();
		
		//setting up font;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font/vegan-style.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 30;
		parameter.color = Color.BLACK;
		font = generator.generateFont(parameter);
		glyphLayout_title = new GlyphLayout();
		glyphLayout_start = new GlyphLayout();
		glyphLayout_title.setText(font, "Fucking Good Game");
		glyphLayout_start.setText(font, "Start Game");
		
		

	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		spriteBatch.dispose();
		texture.dispose();
		music.dispose();
		font.dispose();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(float delta) {
		// TODO Auto-generated method stub
		spriteBatch.begin();
		spriteBatch.draw(texture, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, 0, 0, texture.getWidth(),
				texture.getHeight(), false, false);
		font.draw(spriteBatch, glyphLayout_title, Constants.GAME_WIDTH/2 - glyphLayout_title.width/2, Constants.GAME_HEIGHT - 50);
		font.draw(spriteBatch, glyphLayout_start, Constants.GAME_WIDTH/2 - glyphLayout_start.width/2, 150);
		spriteBatch.end();
		
	}

}
