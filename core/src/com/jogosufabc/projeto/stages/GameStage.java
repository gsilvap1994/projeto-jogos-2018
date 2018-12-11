package com.jogosufabc.projeto.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.jogosufabc.projeto.actors.Enemy;
import com.jogosufabc.projeto.actors.Ground;
import com.jogosufabc.projeto.actors.MainCharacter;
import com.jogosufabc.projeto.actors.StageBackground;
import com.jogosufabc.projeto.utils.BodyUtils;
import com.jogosufabc.projeto.utils.Constants;
import com.jogosufabc.projeto.utils.WorldUtils;

public class GameStage extends Stage implements ContactListener {
	
	
	private static final int VIEWPORT_WIDTH = Constants.GAME_WIDTH;
	private static final int VIEWPORT_HEIGHT = Constants.GAME_HEIGHT;

	private World world;
	private Ground ground;
	private StageBackground stageBackground;
	private MainCharacter main_character;
	private final float TIME_STEP = 1 / 300f;
	private float accumulator = 0f;

	private OrthographicCamera camera;
	private Box2DDebugRenderer renderer;

	private Rectangle screenLeftSide;
	private Rectangle screenRightSide;
	private Vector3 touchPoint;

	public GameStage() {
		super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
				new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
		setUpWorld();
		setUpCamera();
		setupTouchControlAreas();
		renderer = new Box2DDebugRenderer();
	}

	private void setUpWorld() {
		world = WorldUtils.createWorld();
		world.setContactListener(this);
		setupBackground();
		setUpGround();
		setUpMainCharacter();
		setupEnemy();
	}
	
	private void setupBackground() {
		stageBackground = new StageBackground();
		addActor(stageBackground);
	}
	

	private void setUpGround() {
		ground = new Ground(WorldUtils.createGround(world));
		addActor(ground);
	}

	private void setUpMainCharacter() {
		main_character = new MainCharacter(WorldUtils.createCharacter(world));
		addActor(main_character);
	}
	
	private void setupEnemy() {
		Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
		addActor(enemy);
	}

	private void setUpCamera() {
		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
		camera.update();
	}

	private void setupTouchControlAreas() {
		touchPoint = new Vector3();
		screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
		screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
				getCamera().viewportHeight);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }
		
		// Fixed timestep
		accumulator += delta;

		while (accumulator >= delta) {
			world.step(TIME_STEP, 6, 2);
			accumulator -= TIME_STEP;
		}

		// TODO: Implement interpolation

	}
	
	private void update(Body body) {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsEnemy(body) && !main_character.isHit()) {
                setupEnemy();
            }
            world.destroyBody(body);
        }
    }

	

//    @Override
//    public boolean touchDown(int x, int y, int pointer, int button) {
//
//        // Need to get the actual coordinates
//        translateScreenToWorldCoordinates(x, y);
//        
//        if (rightSideTouched(touchPoint.x, touchPoint.y)) {
//            main_character.jump();
//        } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
//            main_character.dodge();
//        }
//
//        return super.touchDown(x, y, pointer, button);
//    }

	@Override
	public boolean keyDown(int keycode) {

		switch (keycode) {
		case Input.Keys.UP:
			main_character.jump();
			break;
		case Input.Keys.DOWN:
			main_character.dodge();
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keyCode) {
		switch(keyCode) {
		case Input.Keys.UP:
			break;
		case Input.Keys.DOWN:
			main_character.isDodging(false);
			break;
		}
		
		return true;
	}

//	private boolean rightSideTouched(float x, float y) {
//		return screenRightSide.contains(x, y);
//	}
//
//	private boolean leftSideTouched(float x, float y) {
//		return screenLeftSide.contains(x, y);
//	}
//
//	private void translateScreenToWorldCoordinates(float x, float y) {
//		getCamera().unproject(touchPoint.set(x, y, 0));
//	}

	@Override
	public void beginContact(Contact contact) {

		Body a = contact.getFixtureA().getBody();
		Body b = contact.getFixtureB().getBody();
		
		if((BodyUtils.bodyIsMainCharacter(a) && BodyUtils.bodyIsEnemy(b)) ||
				BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsMainCharacter(b)) {
			main_character.hit();
		} else if ((BodyUtils.bodyIsMainCharacter(a) && BodyUtils.bodyIsGround(b))
				|| (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsMainCharacter(b))) {
			main_character.landed();
		}
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
