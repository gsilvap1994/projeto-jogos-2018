package com.jogosufabc.projeto.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.jogosufabc.projeto.box2d.MainCharacterUserData;
import com.jogosufabc.projeto.utils.Constants;

public class MainCharacter extends GameActor {

	private boolean jumping;
    private boolean dodging;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion dodgingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    public MainCharacter(Body body) {
        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.MAIN_CHARACTER_ATLAS);
        TextureRegion[] runningFrames = new TextureRegion[Constants.MAIN_CHARACTER_RUNNING.length];
        for (int i = 0; i < Constants.MAIN_CHARACTER_RUNNING.length; i++) {
            String path = Constants.MAIN_CHARACTER_RUNNING[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        runningAnimation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
        
        jumpingTexture = textureAtlas.findRegion(Constants.MAIN_CHARACTER_JUMPING);
        dodgingTexture = textureAtlas.findRegion(Constants.MAIN_CHARACTER_DODGING);
        hitTexture = textureAtlas.findRegion(Constants.MAIN_CHARACTER_HITTING);
    }

    @Override
    public MainCharacterUserData getUserData() {
        return (MainCharacterUserData) userData;
    }

    public void jump() {

        if (!(jumping || dodging)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    public void landed() {
        jumping = false;
    }
    
    public void dodge() {
        if (!jumping) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        body.setTransform(getUserData().getRunningPosition(), 0f);
    }

    public boolean isDodging() {
        return dodging;
    }
    
    public void isDodging(boolean dodging) {
    	this.dodging = dodging;
    	if(!dodging) this.stopDodge();
    }
    
    public boolean isJumping() {
    	return jumping;
    }
    
    public void isJumping(boolean jumping) {
    	this.jumping = jumping;
    }
    
    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
    	super.draw(batch, parentAlpha);
    	float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;
        
    	stateTime += Gdx.graphics.getDeltaTime();
    	if (dodging) {
            batch.draw(dodgingTexture, x, y + screenRectangle.height / 2, width,
                    screenRectangle.height * 3 / 4);
        } else if (hit) {
            // When he's hit we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, x, y, width * 0.5f,
                    screenRectangle.height * 0.5f, width, screenRectangle.height, 1f, 1f,
                    (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            batch.draw(jumpingTexture, x, y, width,
                    screenRectangle.height);
        } else {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw((TextureRegion)runningAnimation.getKeyFrame(stateTime, true), x, y,
                    width, screenRectangle.height);
        }
    }
    
}