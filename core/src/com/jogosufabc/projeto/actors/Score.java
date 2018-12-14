package com.jogosufabc.projeto.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.jogosufabc.projeto.utils.Constants;

public class Score extends Actor {

	private float score;
	private int times;
	private BitmapFont font;

	public Score() {
		score = 0;
		times = 7;
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		score += times * delta;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if (getScore() == 0) {
			return;
		}
		font.draw(batch, "SCORE: "+ getScore(), Constants.GAME_WIDTH - 180, Constants.GAME_HEIGHT -20);
	}

	public int getScore() {
		return (int) Math.floor(score);
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
