package com.jogosufabc.projeto.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jogosufabc.projeto.box2d.EnemyUserData;
import com.jogosufabc.projeto.box2d.GroundUserData;
import com.jogosufabc.projeto.box2d.MainCharacterUserData;
import com.jogosufabc.projeto.enums.EnemyType;

public class WorldUtils {
	
	
	// creates the world of the stage
	public static World createWorld() {
		return new World(Constants.WORLD_GRAVITY, true);
	}
	
	// creates the ground of the stage
	public static Body createGround(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        body.setUserData(new GroundUserData());
        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
        body.createFixture(shape, Constants.GROUND_DENSITY);
        shape.dispose();
        return body;
		
	}
	
	// creates the main character 
	public static Body createCharacter(World world) {
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.MAIN_CHARACTER_X, Constants.MAIN_CHARACTER_Y));
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.MAIN_CHARACTER_WIDTH / 2, Constants.MAIN_CHARACTER_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.MAIN_CHARACTER_GRAVITY_SCALE);
        body.createFixture(shape, Constants.MAIN_CHARACTER_DENSITY);
        body.resetMassData();
        body.setUserData(new MainCharacterUserData(Constants.MAIN_CHARACTER_WIDTH, Constants.MAIN_CHARACTER_HEIGHT));
        shape.dispose();
        return body;
		
	}
	
	// generate randomly the enemies 
	public static Body createEnemy(World world) {
		EnemyType enemyType = GenerateRandomEnemy.getRandomEnemyType();
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.KinematicBody;
		bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);
        Body body = world.createBody(bodyDef);
        body.createFixture(shape, enemyType.getDensity());
        body.resetMassData();
        EnemyUserData userData = new EnemyUserData(enemyType.getWidth(), enemyType.getHeight());
        body.setUserData(userData);
        shape.dispose();
        return body;
	}
}
