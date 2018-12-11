package com.jogosufabc.projeto.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.jogosufabc.projeto.ProjetoFinal;

public class OptionsScreen extends AbstractScreen {
	
	private ProjetoFinal parent;
	private Stage stage;
	private Label titleLabel; 
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;
	
	
	
	public OptionsScreen(String id) {
		super(id);
		
	}
	
	@Override
	public void show() {

		Table table = new Table();
		table.setFillParent(true);
        	table.setDebug(true);
        	stage.addActor(table);

        	Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        
        	//volume
        	final Slider volumeMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
        	        volumeMusicSlider.setValue( parent.getPreferences().getMusicVolume() );
        	        volumeMusicSlider.addListener( new EventListener() {
        	  		@Override
        			public boolean handle(Event event) {
        	  			parent.getPreferences().setMusicVolume( volumeMusicSlider.getValue() );
        	                return false;
        		}
        	});

                	//volume
                	final Slider soundMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
                	   soundMusicSlider.setValue( parent.getPreferences().getMusicVolume() );
                	   soundMusicSlider.addListener( new EventListener() {
                	  		@Override
                			public boolean handle(Event event) {
                	  			parent.getPreferences().setMusicVolume( soundMusicSlider.getValue() );
                	                return false;
                		}
                	});
        	        
        	//music
        	final CheckBox musicCheckbox = new CheckBox(null, skin);
        	musicCheckbox.setChecked( parent.getPreferences().isMusicEnabled() );
        	musicCheckbox.addListener( new EventListener() {
        	    @Override
        	    public boolean handle(Event event) {
        	     boolean enabled = musicCheckbox.isChecked();
        	     parent.getPreferences().setMusicEnabled( enabled );
        	    return false;
        	   }
        	 });
        	
        	//effects
        	final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
        	soundEffectsCheckbox.setChecked( parent.getPreferences().isMusicEnabled() );
        	soundEffectsCheckbox.addListener( new EventListener() {
        	    @Override
        	    public boolean handle(Event event) {
        	     boolean enabled = soundEffectsCheckbox.isChecked();
        	     parent.getPreferences().setMusicEnabled( enabled );
        	    return false;
        	   }
        	 });
		
		
        	 // Main Menu button
        	  final TextButton backButton = new TextButton("Back", skin, "small");
        	    backButton.addListener(new ChangeListener() {
        	      @Override
        	       public void changed(ChangeEvent event, Actor actor) {
        	        	parent.changeScreen(ProjetoFinal.MENU);
        	       }
        	   });
        	        
                	titleLabel = new Label( "Preferences", skin );
                	volumeMusicLabel = new Label( null, skin );
                	volumeSoundLabel = new Label( null, skin );
                	musicOnOffLabel = new Label( null, skin );
                	soundOnOffLabel = new Label( null, skin );
                		
                	table.add(titleLabel);
                	table.row();
                	table.add(volumeMusicLabel);
                	table.add(volumeMusicSlider);
                	table.row();
                	table.add(musicOnOffLabel);
                	table.add(musicCheckbox);
                	table.row();
                	table.add(volumeSoundLabel);
                	table.add(soundMusicSlider);
                	table.row();
                	table.add(soundOnOffLabel);
                	table.add(soundEffectsCheckbox);
                	table.row();
                	table.add(backButton);
        		
		
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