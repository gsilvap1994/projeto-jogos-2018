package com.jogosufabc.projeto.enums;

import com.jogosufabc.projeto.utils.Constants;

public enum EnemyType {

    GROUND_SM(1f, 1f, Constants.ENEMY_START_POS, Constants.GROUND_SM_ENEMY_Y, Constants.ENEMY_DENSITY),
    GROUND_MD(2f, 1f, Constants.ENEMY_START_POS, Constants.GROUND_SM_ENEMY_Y, Constants.ENEMY_DENSITY),
    GROUND_LG(1f, 2f, Constants.ENEMY_START_POS, Constants.GROUND_MD_ENEMY_Y, Constants.ENEMY_DENSITY),
    GROUND_XL(2f, 2f, Constants.ENEMY_START_POS, Constants.GROUND_MD_ENEMY_Y, Constants.ENEMY_DENSITY),
    SKY_SM(1f, 1f, Constants.ENEMY_START_POS, Constants.SKY_ENEMY_Y, Constants.ENEMY_DENSITY),
    SKY_MD(2f, 1f, Constants.ENEMY_START_POS, Constants.SKY_ENEMY_Y, Constants.ENEMY_DENSITY);
	
	private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    
    EnemyType(float width, float height, float x, float y, float density) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.density = density;
    }
    
    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDensity() {
        return density;
    }
}
