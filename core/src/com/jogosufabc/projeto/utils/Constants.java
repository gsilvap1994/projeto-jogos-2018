package com.jogosufabc.projeto.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants {

	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 620;
	
	// world constant
	public static final Vector2 WORLD_GRAVITY = new Vector2(0, -9.8f);
	
	// stage ground constants
	public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f; // change
    public static final float GROUND_HEIGHT = 2f; // change
    public static final float GROUND_DENSITY = 0f;
    
    // stage main character constants
    public static final float MAIN_CHARACTER_X = 2;
    public static final float MAIN_CHARACTER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float MAIN_CHARACTER_WIDTH = 1f;
    public static final float MAIN_CHARACTER_HEIGHT = 2f;
    public static final float MAIN_CHARACTER_GRAVITY_SCALE = 3f;
    public static final float MAIN_CHARACTER_DENSITY = 0.5f;
    public static final float MAIN_CHARACTER_DODGE_X = 2f;
    public static final float MAIN_CHARACTER_DODGE_Y = 1.5f;
    public static final Vector2 MAIN_CHARACTER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    public static final float MAIN_CHARACTER_HIT_ANGULAR_IMPULSE = 10f;
    
    // enemies (4 types) constants
    public static final float ENEMY_START_POS = 25f;
    public static final float ENEMY_DENSITY = MAIN_CHARACTER_DENSITY;
    public static final float GROUND_SM_ENEMY_Y = 1.5f;
    public static final float GROUND_MD_ENEMY_Y = 2f;
    public static final float SKY_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-5f, 0);

}
