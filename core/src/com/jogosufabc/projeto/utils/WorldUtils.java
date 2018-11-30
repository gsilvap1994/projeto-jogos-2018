package com.jogosufabc.projeto.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jogosufabc.projeto.box2d.GroundUserData;
import com.jogosufabc.projeto.box2d.MainCharacterUserData;

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
        body.setUserData(new MainCharacterUserData());
        shape.dispose();
        return body;
		
	}
}
