package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jogosufabc.projeto.AppPreferences;
import com.jogosufabc.projeto.ProjetoFinal;

public class GetUsernameScreen extends Stage implements Screen{
	
	private ProjetoFinal parent;
	private Stage stage;
	TextField textField;
	Skin skin;
	AppPreferences options;
	
	public GetUsernameScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		stage = new Stage(new ScreenViewport());
		skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
		options = new AppPreferences();
		
	}
	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		textField = new TextField("", skin);
		
		final TextButton continueButton = new TextButton("Continue", skin);
		final TextButton backButton = new TextButton("Back", skin);
		
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				parent.changeScreen(ProjetoFinal.START);
			}
		});
		
		continueButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if(textField.getText() == null) return;
				options.setUsername(textField.getText());
				parent.changeScreen(ProjetoFinal.GAME);
			}
		});

		stage.addActor(textField);
		table.row().pad(10, 0, 0, 0);
		table.add(new Label("Type your usename", skin));
		table.row().pad(10, 0, 0, 0);
	    table.add(textField).colspan(2);
		table.row().pad(10,0,0,10);
		table.add(continueButton).colspan(2);
		table.row();
		table.add(backButton).colspan(2);	
		table.row().pad(20, 0, 0, 0);
		
		
	}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
		stage.dispose();
	} 
	
	

}
