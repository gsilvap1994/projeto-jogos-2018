package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.utils.CustomMusic;

public class StartScreen implements Screen {

	private ProjetoFinal parent;
	private Stage stage;
	private Texture texture;
	private CustomMusic music;

	public StartScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		stage = new Stage(new ScreenViewport());
		texture = new Texture(Gdx.files.internal("images/desert_background.png"));
		
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		music = new CustomMusic("audio/opening.mp3", true, parent.getPreferences());
		music.play();
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
		
		TextButton newGame = new TextButton("New Game", skin);
		TextButton preferences = new TextButton("Options", skin);
		TextButton exit = new TextButton("Exit", skin);
		
		table.add(newGame).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(preferences).fillX().uniformX();
		table.row();
		table.add(exit).fillX().uniformX();

		exit.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});

		newGame.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				music.pause();
				music.dispose();
				parent.changeScreen(ProjetoFinal.GAME);
			}
		});

		preferences.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ProjetoFinal.OPTIONS);
			}
		});
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//		stage.getBatch().begin();
//		stage.getBatch().draw(texture, 0, 0, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, 0, 0, texture.getWidth(),
//				texture.getHeight(), false, false);
//		stage.getBatch().end();
		stage.draw();

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
		music.dispose();

	}

}
