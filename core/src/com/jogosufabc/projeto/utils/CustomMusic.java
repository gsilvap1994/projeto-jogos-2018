package com.jogosufabc.projeto.utils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.jogosufabc.projeto.AppPreferences;

public class CustomMusic {
	private boolean looping;
	private Music music;
	private AppPreferences options;
	
	public CustomMusic(String path, boolean looping, AppPreferences options ) {
		this.looping = looping;
		this.options = options;
		this.music = Gdx.audio.newMusic(Gdx.files.internal(path));
	}
	
	// error -> dont update when preferences change
	public void play() {
		if(this.options.isMusicEnabled()) {
			this.music.setVolume(this.options.getMusicVolume());
			this.music.setLooping(looping);
			music.play();
		}
		else music.pause();
	}
	
	public void pause() {
		music.pause();
	}
	
	public void dispose() {
		music.dispose();
	}
 
}
