package com.jogosufabc.projeto.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.jogosufabc.projeto.box2d.MainCharacterUserData;

public class MainCharacter extends GameActor {

	private boolean jumping;
    private boolean dodging;

    public MainCharacter(Body body) {
        super(body);
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
    	return this.jumping;
    }
    
    public void isJumping(boolean jumping) {
    	this.jumping = jumping;
    }
    
}