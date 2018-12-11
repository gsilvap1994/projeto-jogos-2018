package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.utils.Constants;

public class StartScreen extends AbstractScreen{
	
	private ProjetoFinal parent;
	private Stage stage;
	private Texture texture;
	private SpriteBatch spriteBatch;
	private Music music;
	
	public StartScreen(String id) {
		super(id);
		spriteBatch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("index.jpg"));
		
		// opening music
		music = Gdx.audio.newMusic(Gdx.files.internal("audio/opening.mp3"));
		music.setLooping(true);
		music.play();
				
		/// create stage and set it as input processor
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void show() {
		// Create a table that fills the screen. Everything else will go inside this table.
		Table table = new Table();
		table.setFillParent(true);
        	table.setDebug(true);
        	stage.addActor(table);
        
        	// temporary until we have asset manager in
        	Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        
        	//create buttons
        	TextButton newGame = new TextButton("New Game", skin);
        	TextButton preferences = new TextButton("Preferences", skin);
        	TextButton exit = new TextButton("Exit", skin);
        
       		//add buttons to table
        	table.add(newGame).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(preferences).fillX().uniformX();
		table.row();
		table.add(exit).fillX().uniformX();
		
		// create button listeners
		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();				
			}
		});
		
		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ProjetoFinal.APPLICATION);			
			}
		});
		
		preferences.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ProjetoFinal.PREFERENCES);					
			}
		});
		
	}

	@Override
	public void render(float delta) {
		// clear the screen ready for next set of images to be drawn
		spriteBatch.begin();
		spriteBatch.draw(texture, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, 0, 0, texture.getWidth(),
				texture.getHeight(), false, false);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// tell our stage to do actions and draw itself
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		// change the stage's viewport when the screen size is changed
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
		// dispose of assets when not needed anymore
		spriteBatch.dispose();
		texture.dispose();
		music.dispose();
		stage.dispose();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(float delta) {
		// TODO Auto-generated method stub
		
	}

}