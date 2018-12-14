package com.jogosufabc.projeto.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.jogosufabc.projeto.AppPreferences;

public class CustomSound {
	
	private AppPreferences options;
	private Sound sound;
	
	public CustomSound(String path) {
		options = new AppPreferences();
		sound = Gdx.audio.newSound(Gdx.files.internal(path));
		
	}
	
	public void play () {
		if(options.isSoundEffectsEnabled()) {
			this.sound.setVolume(this.sound.play(), this.options.getMusicVolume());
		}
	}
}
