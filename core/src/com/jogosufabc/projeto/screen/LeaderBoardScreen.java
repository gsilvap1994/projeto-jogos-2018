package com.jogosufabc.projeto.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.jogosufabc.projeto.ProjetoFinal;
import com.jogosufabc.projeto.model.LeaderBoard;
import com.jogosufabc.projeto.utils.Api;

public class LeaderBoardScreen extends Stage implements Screen{
	
	private ProjetoFinal parent;
	private Stage stage;
	private ArrayList<LeaderBoard> leaderBoardList;
	private String lb;
	private Label titleLabel;
	private Label usernameLabel;
	private Label scoreLabel;
	private LeaderBoard leaderBoard;
	
	public LeaderBoardScreen(ProjetoFinal projetoFinal) {
		this.parent = projetoFinal;
		stage = new Stage(new ScreenViewport());
		leaderBoard = new LeaderBoard();
		
	
		
		try {
			lb = Api.getLeaderBoard();
			leaderBoardList = leaderBoard.getJsonFromString(lb);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		Gdx.input.setInputProcessor(this);
		
		Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
		
		titleLabel = new Label( "Leaderboard", skin );
		usernameLabel = new Label( "Username", skin );
		scoreLabel = new Label( "Score", skin );
		
		table.add(titleLabel).colspan(2);
		table.row().pad(10,0,0,10);
		table.add(usernameLabel).left();
		table.add(scoreLabel).right();
		table.row().pad(10,0,0,10);
		
		for(LeaderBoard l: leaderBoardList) {
			try {
				table.add(new Label(l.getUsername(), skin)).left();
				table.add(new Label(l.getScore().toString(), skin)).right();
				table.row().pad(10,0,0,10);
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		table.row().pad(20, 0, 0, 20);
		table.add(new Label("Press any key to continue", skin));
		
		
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		parent.changeScreen(ProjetoFinal.CREDITS);
		return true;
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
		// TODO Auto-generated method stubs
		stage.dispose();
		
		
	}

}
