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

public class CreditScreen extends AbstractScreen {
	private Texture texture;
	private SpriteBatch spriteBatch;
	private Music music;
	private BitmapFont font;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private GlyphLayout glyphLayout_title;
	private GlyphLayout glyphLayout_nome1;
	private GlyphLayout glyphLayout_nome2;
	private GlyphLayout glyphLayout_nome3;
	private GlyphLayout glyphLayout_prof;

	public CreditScreen(String id) {
		super(id);
		spriteBatch = new SpriteBatch();
//		spriteBatch.setColor(0, 0, 0, 1);
		texture = new Texture(Gdx.files.internal("images/credito_preto.png"));
		
		//setting up font;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font/vegan-style.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 30;
		parameter.color = Color.WHITE;
		font = generator.generateFont(parameter);
		glyphLayout_title = new GlyphLayout();
		new GlyphLayout();
		glyphLayout_nome1 = new GlyphLayout();
		glyphLayout_nome2 = new GlyphLayout();
		glyphLayout_nome3 = new GlyphLayout();
		glyphLayout_prof = new GlyphLayout();
		glyphLayout_title.setText(font, "CRÉDITOS");
		glyphLayout_nome1.setText(font, "Gabriel");
		glyphLayout_nome2.setText(font, "Henrique");
		glyphLayout_nome3.setText(font, "Murilo");
		glyphLayout_prof.setText(font, "Prof. Isidro");
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
		
	}

	@Override
	public void draw(float delta) {
		spriteBatch.begin();
//		spriteBatch.draw(texture, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, 0, 0, texture.getWidth(),
//				texture.getHeight(), false, false);
		
		font.draw(spriteBatch, glyphLayout_title, Constants.GAME_WIDTH/2 - glyphLayout_title.width/2, Constants.GAME_HEIGHT - 50);
		font.draw(spriteBatch, glyphLayout_nome1, Constants.GAME_WIDTH/2 - glyphLayout_nome1.width/2, Constants.GAME_HEIGHT - 225);
		font.draw(spriteBatch, glyphLayout_nome2, Constants.GAME_WIDTH/2 - glyphLayout_nome2.width/2, Constants.GAME_HEIGHT - 275);
		font.draw(spriteBatch, glyphLayout_nome3, Constants.GAME_WIDTH/2 - glyphLayout_nome3.width/2, Constants.GAME_HEIGHT - 325);
		font.draw(spriteBatch, glyphLayout_prof,  Constants.GAME_WIDTH/2 - glyphLayout_prof.width/2,  Constants.GAME_HEIGHT - 500);
		spriteBatch.end();
	}

}